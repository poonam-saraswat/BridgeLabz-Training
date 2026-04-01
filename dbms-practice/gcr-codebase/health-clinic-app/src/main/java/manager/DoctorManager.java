package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Doctor;
import exception.ClinicException;

public class DoctorManager {
    
    // UC - 2.1
     public int addDoctor(Doctor doctor) throws ClinicException, SQLException {
        String sql = """
            INSERT INTO doctors(name, specialty_id, contact, fee)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, doctor.getDoctorName());
            ps.setInt(2, doctor.getSpecialtyId());
            ps.setString(3, doctor.getDoctorContact());
            ps.setDouble(4, doctor.getFee());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        }
    }

    // UC - 2.2
    public void updateDoctorSpecialty(int doctorId, String newSpecialty) throws SQLException, ClinicException{
        String sql = "UPDATE doctors SET specialization = ? WHERE doctor_id = ?";

        try(Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, newSpecialty);
            ps.setInt(2, doctorId);

            int rows = ps.executeUpdate();
            if(rows == 0){
                throw new ClinicException("Doctor not found!");
            }
        }
        catch(Exception e){
            throw new ClinicException("Error updating doctor speciality!");
        }
    }

    // UC - 2.3
    public List<Doctor> viewDoctorsBySpecialty(String specialty) throws ClinicException, SQLException{
        String sql = """
                SELECT d.doctor_id, d.doctor_name, d.specialization, d.contact, d.fee, s.specialty_name, a.appointment_date
                FROM doctors d
                JOIN specialties s ON d.specialty_id = s.specialty_id
                LEFT JOIN appointments a ON d.doctor_id = a.doctor_id
                WHERE s.specialty_name = ?
                ORDER BY a.appointment_date
        """;

        List<Doctor> doctors = new ArrayList<>();

        try(Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, specialty);

            ResultSet set = ps.executeQuery();

            while(set.next()){
                doctors.add(new Doctor(
                    set.getInt("doctor_id"),
                    set.getString("doctor_name"),
                    set.getString("specialization"),
                    set.getString("contact"),
                    set.getDouble("fee"),
                    set.getInt("speciality_id")
                ));
            }

            return doctors;
        }
        catch(Exception e){
            throw new ClinicException("No doctors with such specialty.");
        }
    }

    // UC - 2.4
    public void deactivateDoctor(int doctorId) throws ClinicException, SQLException {
        String sql = """
            UPDATE doctors
            SET is_active=FALSE
            WHERE doctor_id=?
            AND doctor_id NOT IN (
                SELECT doctor_id FROM appointments
                WHERE appointment_date > CURRENT_DATE
            )
        """;

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            if (ps.executeUpdate() == 0) {
                throw new ClinicException("Doctor cannot be deactivated");
            }
        }
    }
}
