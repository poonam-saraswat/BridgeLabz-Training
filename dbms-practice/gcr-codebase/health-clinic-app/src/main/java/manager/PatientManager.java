package manager;

import java.sql.*;
import database.DBConnection;
import exception.ClinicException;
import model.Patient;

public class PatientManager {

    // UC-1.1
    public int registerPatient(Patient patient) throws ClinicException, SQLException {

        String sql = """
            INSERT INTO patients(name, dob, contact, email, address, blood_group)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps =
                 connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, patient.getPatientName());
            ps.setDate(2, Date.valueOf(patient.getPatientDOB()));
            ps.setString(3, patient.getPatientContact());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getPatientAddress());
            ps.setString(6, patient.getPatientBloodgGroup());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
            throw new ClinicException("Patient ID not generated");

        } catch (Exception e) {
            throw new ClinicException("Error registering patient");
        }
    }

    // UC-1.2
    public void updatePatient(Patient patient) throws ClinicException, SQLException {

        String sql = """
            UPDATE patients
            SET name=?, dob=?, contact=?, email=?, address=?, blood_group=?
            WHERE patient_id=?
        """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, patient.getPatientName());
            ps.setDate(2, Date.valueOf(patient.getPatientDOB()));
            ps.setString(3, patient.getPatientContact());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getPatientAddress());
            ps.setString(6, patient.getPatientBloodgGroup());
            ps.setInt(7, patient.getPatientId());

            if (ps.executeUpdate() == 0) {
                throw new ClinicException("Patient not found");
            }
        }
    }

    // UC-1.3
    public void searchPatientByIdOrPhone(String key) throws ClinicException, SQLException {

        String sql = "SELECT * FROM patients WHERE patient_id=? OR contact=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, key);
            ps.setString(2, key);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                    rs.getInt("patient_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("contact")
                );
            }
        }
    }

    // UC-1.4
    public void viewPatientHistory(int patientId) throws ClinicException, SQLException {

        String sql = """
            SELECT a.appointment_date, d.name, v.diagnosis
            FROM appointments a
            JOIN visits v ON a.appointment_id=v.appointment_id
            JOIN doctors d ON a.doctor_id=d.doctor_id
            WHERE a.patient_id=?
            ORDER BY a.appointment_date
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getDate(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getString(3)
                );
            }
        }
    }
}