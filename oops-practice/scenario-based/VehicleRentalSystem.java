import java.util.*;

// Abstraction: Interface
interface IRentable {
    double calculateRent(int days);
}

// Base class: Vehicle
abstract class Vehicle implements IRentable {
    protected int vehicleId;
    protected String brand;
    protected String model;
    protected double dailyRate;

    public Vehicle(int vehicleId, String brand, String model, double dailyRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
    }

    // Encapsulation: getters and setters
    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    // Polymorphism: overridden in subclasses
    public abstract void displayInfo();
}

// Inheritance: Bike
class Bike extends Vehicle {
    public Bike(int id, String brand, String model, double rate) {
        super(id, brand, model, rate);
    }

    @Override
    public double calculateRent(int days) {
        return days * dailyRate;
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike: " + brand + " " + model + " (ID: " + vehicleId + ")");
        System.out.println("Daily Rate: $" + dailyRate);
    }
}

// Inheritance: Car
class Car extends Vehicle {
    private boolean luxury;

    public Car(int id, String brand, String model, double rate, boolean luxury) {
        super(id, brand, model, rate);
        this.luxury = luxury;
    }

    @Override
    public double calculateRent(int days) {
        return days * dailyRate + (luxury ? 500 : 0); // extra fee for luxury cars
    }

    @Override
    public void displayInfo() {
        System.out.println("Car: " + brand + " " + model + " (ID: " + vehicleId + ")");
        System.out.println("Daily Rate: $" + dailyRate + ", Luxury: " + luxury);
    }
}

// Inheritance: Truck
class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(int id, String brand, String model, double rate, double loadCapacity) {
        super(id, brand, model, rate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRent(int days) {
        return days * dailyRate + (loadCapacity * 10); // surcharge based on capacity
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck: " + brand + " " + model + " (ID: " + vehicleId + ")");
        System.out.println("Daily Rate: $" + dailyRate + ", Load Capacity: " + loadCapacity + " tons");
    }
}

// Customer class
class Customer {
    protected int customerId;
    protected String name;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Customer: " + name + " (ID: " + customerId + ")");
    }
}

// Rental Management System with CRUD
public class VehicleRentalSystem {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();

    // CRUD for Vehicles
    public static void addVehicle(Vehicle v) {
        vehicles.add(v);
        System.out.println("Vehicle added successfully!");
    }

    public static void viewVehicles() {
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println("----------------");
        }
    }

    public static void updateVehicleRate(int id, double newRate) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleId() == id) {
                v.setDailyRate(newRate);
                System.out.println("Vehicle rate updated!");
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }

    public static void deleteVehicle(int id) {
        vehicles.removeIf(v -> v.getVehicleId() == id);
        System.out.println("Vehicle deleted!");
    }

    // CRUD for Customers
    public static void addCustomer(Customer c) {
        customers.add(c);
        System.out.println("Customer added successfully!");
    }

    public static void viewCustomers() {
        for (Customer c : customers) {
            c.displayInfo();
            System.out.println("----------------");
        }
    }

    public static void deleteCustomer(int id) {
        customers.removeIf(c -> c.customerId == id);
        System.out.println("Customer deleted!");
    }

    // Rent a vehicle
    public static void rentVehicle(int vehicleId, int customerId, int days) {
        Vehicle v = null;
        Customer c = null;

        for (Vehicle veh : vehicles) {
            if (veh.getVehicleId() == vehicleId) {
                v = veh;
                break;
            }
        }

        for (Customer cust : customers) {
            if (cust.customerId == customerId) {
                c = cust;
                break;
            }
        }

        if (v != null && c != null) {
            System.out.println("----- RENT RECEIPT -----");
            c.displayInfo();
            v.displayInfo();
            System.out.println("Days: " + days);
            System.out.println("Total Rent: $" + v.calculateRent(days));
            System.out.println("------------------------");
        } else {
            System.out.println("Invalid Vehicle or Customer ID!");
        }
    }

    // Main method
    public static void main(String[] args) {
        // Add Vehicles
        addVehicle(new Bike(1, "Yamaha", "FZ", 300));
        addVehicle(new Car(2, "Honda", "City", 1000, false));
        addVehicle(new Truck(3, "Tata", "HeavyDuty", 2000, 5));

        // Add Customers
        addCustomer(new Customer(101, "Poonam"));
        addCustomer(new Customer(102, "Rahul"));

        // View Vehicles and Customers
        viewVehicles();
        viewCustomers();

        // Rent Vehicle
        rentVehicle(2, 101, 3);

        // Update Vehicle Rate
        updateVehicleRate(1, 350);

        // Delete Vehicle
        deleteVehicle(3);

        // View Vehicles after update/delete
        viewVehicles();
    }
}