import java.util.*;
class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 50.0; // Assuming a fixed cost per day

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    // Method to display rental details
    public void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }
}
class CarRentalTest {
    public static void main(String[] args) {
        // Creating a CarRental object using parameterized constructor
        CarRental rental = new CarRental("Bob Smith", "Toyota Camry", 4);
        System.out.println("Car Rental Details:");
        rental.displayDetails();
    }
}