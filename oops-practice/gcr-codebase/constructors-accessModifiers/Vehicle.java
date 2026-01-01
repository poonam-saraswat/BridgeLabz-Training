import java.util.*;
class Vehicle {
    // Static variable for registration fee
    static double registrationFee = 150.0;

    // Final variable for unique registration number
    final String registrationNumber;
    String ownerName;
    String vehicleType;

    // Constructor using 'this' to initialize instance variables
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: $" + registrationFee);
    }
}
class VehicleTest {
    public static void main(String[] args) {
        // Creating Vehicle objects
        Vehicle vehicle1 = new Vehicle("Honest raj", "Sedan", "ABC123");
        Vehicle vehicle2 = new Vehicle("Price danish", "SUV", "XYZ789");

        // Checking instanceof and displaying details for vehicle1
        if (vehicle1 instanceof Vehicle) {
            vehicle1.displayDetails();
        }

        System.out.println();

        // Checking instanceof and displaying details for vehicle2
        if (vehicle2 instanceof Vehicle) {
            vehicle2.displayDetails();
        }
    }
}