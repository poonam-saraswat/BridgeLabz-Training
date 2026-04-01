package model;

import java.time.LocalDate;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private LocalDate appointmentDate;
    private String status;

    public Appointment(){}

    public Appointment(int appointmentId, int patientId, int doctorId, LocalDate appointmentDate, String status){
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public int getAppointmentId(){ return appointmentId; }
    public int getPatientID(){ return patientId; }
    public int getDoctorID(){ return doctorId;}
    public LocalDate getAppointmentDate(){ return appointmentDate; }
    public String getStatus(){ return status; }

    public void setAppointmentId(int appointmentId){this.appointmentId = appointmentId;}
    public void setPatientID(int patientId){this.patientId = patientId;}
    public void setDoctorID(int doctorId){this.doctorId = doctorId; }
    public void setAppointmentDate(LocalDate appointmentDate){ this.appointmentDate = appointmentDate; }
    public void setStatus(String status){ this.status = status;}
}
