// Abstraction: Interface for payment
interface IPayable {
    double calculateBill();
}

// Base class: Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    // Encapsulation: getters and setters
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // Polymorphism: will be overridden
    public abstract void displayInfo();
}

// Inheritance: InPatient
class InPatient extends Patient implements IPayable {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(int id, String name, int age, int daysAdmitted, double dailyRate) {
        setPatientId(id);
        setName(name);
        setAge(age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void displayInfo() {
        System.out.println("InPatient: " + getName() + " (ID: " + getPatientId() + ")");
        System.out.println("Age: " + getAge() + ", Days Admitted: " + daysAdmitted);
        System.out.println("Bill: $" + calculateBill());
    }
}

// Inheritance: OutPatient
class OutPatient extends Patient implements IPayable {
    private double consultationFee;

    public OutPatient(int id, String name, int age, double consultationFee) {
        setPatientId(id);
        setName(name);
        setAge(age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("OutPatient: " + getName() + " (ID: " + getPatientId() + ")");
        System.out.println("Age: " + getAge());
        System.out.println("Consultation Fee: $" + calculateBill());
    }
}

// Doctor class
class Doctor {
    private int doctorId;
    private String doctorName;
    private String specialization;

    public Doctor(int doctorId, String doctorName, String specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("Doctor: " + doctorName + " (ID: " + doctorId + ")");
        System.out.println("Specialization: " + specialization);
    }
}

// Bill class
class Bill {
    private Patient patient;
    private Doctor doctor;

    public Bill(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    public void generateBill() {
        System.out.println("----- BILL -----");
        doctor.displayInfo();
        patient.displayInfo();
        System.out.println("----------------");
    }
}

// Main class with CRUD operations
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Create doctor
        Doctor doc1 = new Doctor(101, "Dr. Sharma", "Cardiology");

        // Create patients
        Patient p1 = new InPatient(1, "Poonam", 25, 5, 2000);
        Patient p2 = new OutPatient(2, "Rahul", 30, 500);

        // Generate bills
        Bill b1 = new Bill(p1, doc1);
        Bill b2 = new Bill(p2, doc1);

        b1.generateBill();
        b2.generateBill();
    }
}