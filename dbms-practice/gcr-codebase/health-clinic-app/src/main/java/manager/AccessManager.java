package manager;

import java.sql.*;
import database.DBConnection;
import exception.ClinicException;
import model.Specialty;

public class AccessManager {
    public void addSpecialty(Specialty specialty) throws ClinicException, SQLException {
        String sql = """
            INSERT INTO specialties (specialty_name, description)
            VALUES (?, ?)
        """;

        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, specialty.getSpecialtyName());
            ps.setString(2, specialty.getDescription());
            ps.executeUpdate();

        } 
        catch (Exception e) {
            throw new ClinicException("Error adding specialty.");
        }
    }

    public void updateSpecialty(Specialty specialty) throws ClinicException, SQLException {
        String sql = """
            UPDATE specialties
            SET specialty_name = ?, description = ?
            WHERE specialty_id = ?
        """;

        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, specialty.getSpecialtyName());
            ps.setString(2, specialty.getDescription());
            ps.setInt(3, specialty.getSpecialtyId());

            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new ClinicException("Specialty not found.");
            }

        } catch (Exception e) {
            throw new ClinicException("Error updating specialty.");
        }
    }

    public void deleteSpecialty(int specialtyId) throws ClinicException, SQLException {
        String sql1 = """
            SELECT COUNT(*)
            FROM doctors
            WHERE specialty_id = ?
        """;

        String sql2 = """
            DELETE FROM specialties
            WHERE specialty_id = ?
        """;

        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps1 = connection.prepareStatement(sql1)) {
            ps1.setInt(1, specialtyId);
            ResultSet rs = ps1.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                throw new ClinicException(
                    "Cannot delete specialty. Doctors are assigned."
                );
            }

            try (PreparedStatement ps2 = connection.prepareStatement(sql2)) {
                ps2.setInt(1, specialtyId);
                ps2.executeUpdate();
            }

        } catch (Exception e) {
            throw new ClinicException("Error deleting specialty.");
        }
    }

   
    public void backupDatabase() throws ClinicException, SQLException {
        try (Connection connection = DBConnection.getConnection()) {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet tables = meta.getTables( null, null, "%", new String[]{"TABLE"});

            System.out.println("Backing up tables...");

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Exporting table: " + tableName);
            }

        } 
        catch (Exception e) {
            throw new ClinicException("Error during database backup.");
        }
    }

    
    public void viewAuditLogs(String user, String table) throws ClinicException, SQLException {
        String sql = """
            SELECT user_name, action_type, table_name, action_time
            FROM audit_log
            WHERE user_name LIKE ?
            AND table_name LIKE ?
            ORDER BY action_time DESC
        """;

        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + user + "%");
            ps.setString(2, "%" + table + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("User | Action | Table | Time");
            System.out.println("------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getString("user_name") + " | " +
                    rs.getString("action_type") + " | " +
                    rs.getString("table_name") + " | " +
                    rs.getTimestamp("action_time")
                );
            }

        } catch (Exception e) {
            throw new ClinicException("Error viewing audit logs.");
        }
    }
}