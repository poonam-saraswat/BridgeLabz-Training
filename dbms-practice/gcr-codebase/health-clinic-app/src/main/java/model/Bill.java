package model;

import java.time.LocalDate;

public class Bill {

    private int billId;
    private int visitId;
    private int patientId;
    private int doctorId;
    private double totalAmount;
    private String paymentStatus;
    private LocalDate billDate;

    public Bill() {}

    public Bill(int visitId, int patientId, int doctorId, double totalAmount, String paymentStatus) {
        this.visitId = visitId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    public int getBillId() { return billId; }
    public int getVisitId() { return visitId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public double getTotalAmount() { return totalAmount; }
    public String getPaymentStatus() { return paymentStatus; }
    public LocalDate getBillDate() { return billDate; }

    public void setBillId(int billId) { this.billId = billId; }
}