package manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Appointment;
import exception.ClinicException;

public class AppointmentManager {
    
     public void bookAppointment(Appointment a) throws ClinicException, SQLException {

        String checkSql = """
            SELECT COUNT(*) FROM appointments
            WHERE doctor_id=? AND appointment_date=? AND status='SCHEDULED'
        """;

        String insertSql = """
            INSERT INTO appointments(patient_id, doctor_id, appointment_date, status)
            VALUES (?, ?, ?, 'SCHEDULED')
        """;

        try (Connection con = DBConnection.getConnection(); PreparedStatement checkPs = con.prepareStatement(checkSql)) {
            checkPs.setInt(1, a.getDoctorID());
            checkPs.setDate(2, Date.valueOf(a.getAppointmentDate()));
            ResultSet rs = checkPs.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0)
                throw new ClinicException("Doctor not available");

            try (PreparedStatement insertPs = con.prepareStatement(insertSql)) {
                insertPs.setInt(1, a.getPatientID());
                insertPs.setInt(2, a.getDoctorID());
                insertPs.setDate(3, Date.valueOf(a.getAppointmentDate()));
                insertPs.executeUpdate();
            }
        }
    }

    public void cancelAppointment(int appointmentId) throws ClinicException, SQLException {

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement("UPDATE appointments SET status='CANCELLED' WHERE appointment_id=?");
            ps1.setInt(1, appointmentId);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement("INSERT INTO appointment_audit VALUES (?, 'CANCELLED', CURRENT_TIMESTAMP)");
            ps2.setInt(1, appointmentId);
            ps2.executeUpdate();

            con.commit();
        }
    }

    public void rescheduleAppointment(int doctorId, int appointmentId, java.sql.Date newDate) throws ClinicException, SQLException{
        String sql1 = """
            COUNT(*) FROM appointments
            WHERE doctor_id = ? AND appointment_date = ?
            AND status = 'SCHEDULED'
        """;

        String sql2 = """
            UPDATE appointments
            SET doctor_id = ? AND appointment_date = ?
            WHERE appointment_id = ?        
        """;

        try(Connection connection = DBConnection.getConnection()){
            connection.setAutoCommit(false);

            try(PreparedStatement ps1 = connection.prepareStatement(sql1)){
                ps1.setInt(1, doctorId);
                ps1.setDate(2, newDate);

                ResultSet set = ps1.executeQuery();
                set.next();

                if(set.getInt(1) > 0){
                    throw new ClinicException("Appointment date is already booked.");
                }
            

                try(PreparedStatement ps2 = connection.prepareStatement(sql2)){
                    ps2.setInt(1, doctorId);
                    ps2.setDate(2, newDate);
                    ps2.setInt(3, appointmentId);

                    ps2.executeQuery();
                }

                connection.commit();
            }
            catch(Exception e){
                connection.rollback();
                throw new ClinicException("Error rescheduling appointment.");
            }
        }
    }

    public void viewAppointmentSchedule(java.sql.Date date) throws ClinicException, SQLException{
        String sql = """
                SELECT 
                a.appointment_id,
                p.name AS patient_name,
                d.name AS doctor_name,
                a.status
            FROM appointments a
            JOIN patients p ON a.patient_id = p.patient_id
            JOIN doctors d ON a.doctor_id = d.doctor_id
            WHERE a.appointment_date = ?
            ORDER BY d.name
        """;

        try(Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setDate(1, date);

            ResultSet set = ps.executeQuery();

            System.out.println("ID | Patient | Doctor | Status");
            System.out.println("------------------------------");

            while(set.next()){
                System.out.println(
                    set.getInt("appointment_id") + " | " +
                    set.getString("patient_name") + " | " +
                    set.getString("doctor_name") + " | " +
                    set.getString("status")
                );
            }
        }
        catch(Exception e){
                throw new ClinicException("Error viewing appointment schedule");
        }
    }
}
