// Interface for Medical Records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class Patient
abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis; // sensitive data
    private String medicalHistory; // sensitive data

    // Constructor
    public Patient(int patientId, String name, int age, String diagnosis, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = medicalHistory;
    }

    // Encapsulation: Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Sensitive fields: only getters, no setters
    public String getDiagnosis() {
        return diagnosis;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Bill Amount: " + calculateBill());
        System.out.println("-----------------------------------");
    }

    // MedicalRecord interface methods
    @Override
    public void addRecord(String record) {
        this.medicalHistory += "; " + record;
        System.out.println("Record added for " + name + ": " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records of " + name + ": " + medicalHistory);
    }
}

// InPatient subclass
class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(int patientId, String name, int age, String diagnosis, String medicalHistory,
                     int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis, medicalHistory);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }
}

// OutPatient subclass
class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int patientId, String name, int age, String diagnosis, String medicalHistory,
                      double consultationFee) {
        super(patientId, name, age, diagnosis, medicalHistory);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}

// Main class
public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient p1 = new InPatient(101, "Alice", 30, "Pneumonia", "No major history", 5, 2000);
        Patient p2 = new OutPatient(102, "Bob", 25, "Flu", "Allergy history", 500);

        // Polymorphism: process patients using Patient reference
        Patient[] patients = {p1, p2};

        for (Patient patient : patients) {
            patient.getPatientDetails();
            patient.addRecord("Follow-up scheduled");
            patient.viewRecords();
            System.out.println("-----------------------------------");
        }
    }
}
