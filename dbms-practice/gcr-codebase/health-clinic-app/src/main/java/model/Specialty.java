package model;

public class Specialty {

    private int specialtyId;
    private String specialtyName;
    private String description;

    public Specialty() {}

    public Specialty(int specialtyId, String specialtyName, String description) {
        this.specialtyId = specialtyId;
        this.specialtyName = specialtyName;
        this.description = description;
    }

    public int getSpecialtyId() { return specialtyId; }
    public String getSpecialtyName() { return specialtyName; }
    public String getDescription() { return description; }

    public void setSpecialtyId(int specialtyId) { this.specialtyId = specialtyId; }
    public void setSpecialtyName(String specialtyName) { this.specialtyName = specialtyName; }
    public void setDescription(String description) { this.description = description; }
}