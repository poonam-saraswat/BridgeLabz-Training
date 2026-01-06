// Interface for Insurable vehicles
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class Vehicle
abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber; // sensitive detail

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Encapsulation: Getters and Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Sensitive field: only getter, no setter
    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Display details
    public void displayDetails(int days) {
        double rentalCost = calculateRentalCost(days);
        double insuranceCost = calculateInsurance();
        double totalCost = rentalCost + insuranceCost;

        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
        System.out.println("Rental Cost for " + days + " days: " + rentalCost);
        System.out.println("Insurance Cost: " + insuranceCost);
        System.out.println("Insurance Details: " + getInsuranceDetails());
        System.out.println("Total Cost: " + totalCost);
        System.out.println("-----------------------------------");
    }
}

// Car subclass
class Car extends Vehicle {
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days; // simple daily rate
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: 15% of rental rate";
    }
}

// Bike subclass
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8; // 20% discount for bikes
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: 5% of rental rate";
    }
}

// Truck subclass
class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // extra fixed charge
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.25; // 25% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: 25% of rental rate";
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Car("CAR123", 2000, "POLICY-CAR-001");
        Vehicle v2 = new Bike("BIKE456", 500, "POLICY-BIKE-002");
        Vehicle v3 = new Truck("TRUCK789", 5000, "POLICY-TRUCK-003");

        Vehicle[] vehicles = {v1, v2, v3};

        // Polymorphism: iterate over vehicles
        for (Vehicle v : vehicles) {
            v.displayDetails(5); // rental for 5 days
        }
    }
}
