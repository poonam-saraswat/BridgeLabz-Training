package model;

import java.time.LocalDate;

public class Patient {
    private int patientId;
    private String patientName;
    private String patientContact;
    private String email;
    private LocalDate patientDOB;
    private String address;
    private String bloodGroup;

    public Patient() {
    }

    public Patient(int patientId, String patientName, String patientContact, String email, LocalDate patientDOB,
            String address, String bloodGroup) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientContact = patientContact;
        this.email = email;
        this.patientDOB = patientDOB;
        this.address = address;
        this.bloodGroup = bloodGroup;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getPatientDOB() {
        return patientDOB;
    }

    public String getPatientAddress() {
        return address;
    }

    public String getPatientBloodgGroup() {
        return bloodGroup;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPatientDOB(LocalDate patientDOB) {
        this.patientDOB = patientDOB;
    }

    public void setPatientAddress(String address) {
        this.address = address;
    }

    public void setPatientBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
