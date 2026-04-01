package model;

public class Doctor {
    private int doctorId;
    private String doctorName;
    private String specialization;
    private String contact;
    private double fee;
    private int speciality_id;

    public Doctor(){}

    public Doctor(int doctorId, String doctorName, String specialization, String contact, double fee, int speciality_id){
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.contact = contact;
        this.fee = fee;
        this.speciality_id = speciality_id;
    }

    public int getDoctorId(){ return doctorId; }
    public int getSpecialtyId(){ return speciality_id; }
    public String getDoctorName(){ return doctorName; }
    public String getSpecialization(){ return specialization;}
    public String getDoctorContact(){ return contact; }
    public double getFee(){ return fee;}

    public void setDoctorId(int doctorId){this.doctorId = doctorId;}
    public void setDoctorName(String doctorName){this.doctorName = doctorName;}
    public void setSpecialization(String specialization){this.specialization = specialization; }
    public void setDoctorContact(String contact){this.contact = contact;}
    public void setFee(double fee){this.fee = fee;}
    public void setSpecialityId(int specialityId){this.speciality_id = specialityId; }
}
