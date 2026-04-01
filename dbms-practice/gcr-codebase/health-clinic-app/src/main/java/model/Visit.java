package model;

import java.time.LocalDate;

public class Visit {
    private int visitId;
    private int appointmentId;
    private LocalDate visitDate;
    private String diagnosis;
    private String notes;
  

    public Visit(){}

    public Visit(int visitId, int appointmentId, LocalDate visitDate, String diagnosis, String notes){
        this.visitId = visitId;
        this.appointmentId = appointmentId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.notes = notes;
        
    }

    public int getVisitId(){ return visitId; }
    public int getAppointmentId(){ return appointmentId; }
    public LocalDate getVisitDate(){ return visitDate; }
    public String getDiagnosis(){ return diagnosis;}
    public String getNotes(){ return notes; }
    

    public void setVisitId(int visitId){ this.visitId = visitId; }
    public void setAppointmentId(int appointmentId){ this.appointmentId = appointmentId; }
    public void setDiagnosis(String diagnosis){this.diagnosis = diagnosis;}
    public void setNotes(String notes){ this.notes = notes; }
    public void setVisitDate(LocalDate visitDate){ this.visitDate = visitDate; }
}
