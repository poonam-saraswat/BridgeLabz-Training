package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import exception.ClinicException;
import model.Bill;

public class BillingManager {

    public void generateBill(Bill bill, double consultationFee, double[] additionalCharges) throws ClinicException, SQLException {
        String sql1 = """
            INSERT INTO bills
            (visit_id, patient_id, doctor_id, total_amount, payment_status)
            VALUES (?, ?, ?, ?, 'UNPAID')
        """;

        String sql2 = """
            INSERT INTO bill_items (bill_id, description, amount)
            VALUES (?, ?, ?)
        """;

        try (Connection connection = DBConnection.getConnection()) {
            connection.setAutoCommit(false);

            double total = consultationFee;
            for (double amt : additionalCharges) {
                total += amt;
            }

            try (PreparedStatement ps1 = connection.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS)) {
                ps1.setInt(1, bill.getVisitId());
                ps1.setInt(2, bill.getPatientId());
                ps1.setInt(3, bill.getDoctorId());
                ps1.setDouble(4, total);
                ps1.executeUpdate();

                ResultSet rs = ps1.getGeneratedKeys();
                rs.next();
                int billId = rs.getInt(1);

                try (PreparedStatement ps2 = connection.prepareStatement(sql2)) {
                    ps2.setInt(1, billId);
                    ps2.setString(2, "Consultation Fee");
                    ps2.setDouble(3, consultationFee);
                    ps2.addBatch();

                    for (double amt : additionalCharges) {
                        ps2.setInt(1, billId);
                        ps2.setString(2, "Additional Charge");
                        ps2.setDouble(3, amt);
                        ps2.addBatch();
                    }

                    ps2.executeBatch();
                }

                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                throw new ClinicException("Error generating bill.");
            }
        }
    }

    public void recordPayment(int billId, String mode) throws ClinicException, SQLException {
        String sql1 = """
            UPDATE bills
            SET payment_status = 'PAID'
            WHERE bill_id = ?
        """;

        String sql2 = """
            INSERT INTO payment_transactions
            (bill_id, payment_date, payment_mode, amount)
            SELECT bill_id, CURRENT_DATE, ?, total_amount
            FROM bills
            WHERE bill_id = ?
        """;

        try (Connection connection = DBConnection.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement ps1 = connection.prepareStatement(sql1); PreparedStatement ps2 = connection.prepareStatement(sql2)) {
                ps1.setInt(1, billId);
                ps1.executeUpdate();

                ps2.setString(1, mode);
                ps2.setInt(2, billId);
                ps2.executeUpdate();

                connection.commit();
            } 
            catch (Exception e) {
                connection.rollback();
                throw new ClinicException("Error recording payment.");
            }
        }
    }


    public void viewOutstandingBills() throws ClinicException, SQLException {
        String sql = """
            SELECT 
                p.name AS patient_name,
                COUNT(b.bill_id) AS total_bills,
                SUM(b.total_amount) AS total_due
            FROM bills b
            JOIN patients p ON b.patient_id = p.patient_id
            WHERE b.payment_status = 'UNPAID'
            GROUP BY p.name
        """;

        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            System.out.println("Patient | Bills | Amount Due");
            System.out.println("-----------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getString("patient_name") + " | " +
                    rs.getInt("total_bills") + " | " +
                    rs.getDouble("total_due")
                );
            }
        }
    }

    public void generateRevenueReport(java.sql.Date from, java.sql.Date to) throws ClinicException, SQLException {
        String sql = """
            SELECT 
                d.name AS doctor_name,
                SUM(b.total_amount) AS revenue
            FROM bills b
            JOIN doctors d ON b.doctor_id = d.doctor_id
            WHERE b.payment_status = 'PAID'
            AND b.bill_date BETWEEN ? AND ?
            GROUP BY d.name
            HAVING SUM(b.total_amount) > 0
        """;

        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, from);
            ps.setDate(2, to);

            ResultSet rs = ps.executeQuery();

            System.out.println("Doctor | Revenue");
            System.out.println("----------------");

            while (rs.next()) {
                System.out.println(
                    rs.getString("doctor_name") + " | " +
                    rs.getDouble("revenue")
                );
            }
        }
    }
}