import java.util.*;

// Exception Handling
class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

// Entity: User
class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() { return name; }
    public int getUserId() { return userId; }
}

// Entity: Driver
class Driver {
    private String name;
    private int driverId;
    private boolean available = true;

    public Driver(String name, int driverId) {
        this.name = name;
        this.driverId = driverId;
    }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public String getName() { return name; }
}

// Entity: Ride
class Ride {
    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    public Ride(User user, Driver driver, double distance, FareCalculator calculator) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = calculator.calculateFare(distance);
    }

    public double getFare() { return fare; }
    public Driver getDriver() { return driver; }
    public String getRideDetails() {
        return "User: " + user.getName() + ", Driver: " + driver.getName() +
               ", Distance: " + distance + " km, Fare: ₹" + fare;
    }
}

// Interface: FareCalculator
interface FareCalculator {
    double calculateFare(double distance);
}

// Polymorphism: Normal Pricing
class NormalFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10; // ₹10 per km
    }
}

// Polymorphism: Peak Pricing
class PeakFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15; // ₹15 per km during peak
    }
}

// Ride Management System
class RideManager {
    private List<Driver> drivers = new ArrayList<>();
    private List<Ride> rideHistory = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public Ride bookRide(User user, double distance, FareCalculator calculator) throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.isAvailable()) {
                d.setAvailable(false); // assign driver
                Ride ride = new Ride(user, d, distance, calculator);
                rideHistory.add(ride);
                return ride;
            }
        }
        throw new NoDriverAvailableException("No drivers available at the moment!");
    }

    public void completeRide(Ride ride) {
        rideHistory.add(ride);
        ride.getDriver().setAvailable(true); // driver becomes free again
    }

    public void showRideHistory() {
        System.out.println("Ride History:");
        for (Ride r : rideHistory) {
            System.out.println(r.getRideDetails());
        }
    }
}

// Test Class
public class CarBooking {
    public static void main(String[] args) {
        try {
            User u1 = new User("Alice", 101);
            User u2 = new User("Bob", 102);

            Driver d1 = new Driver("John", 201);
            Driver d2 = new Driver("Mike", 202);

            RideManager manager = new RideManager();
            manager.addDriver(d1);
            manager.addDriver(d2);

            // Normal fare ride
            Ride ride1 = manager.bookRide(u1, 12, new NormalFareCalculator());
            System.out.println(ride1.getRideDetails());

            // Peak fare ride
            Ride ride2 = manager.bookRide(u2, 8, new PeakFareCalculator());
            System.out.println(ride2.getRideDetails());

            manager.showRideHistory();

        } catch (NoDriverAvailableException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }
}