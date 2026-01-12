import java.util.*;

// Flight class
class Flight {
    private int flightId;
    private String source;
    private String destination;
    private double price;

    public Flight(int flightId, String source, String destination, double price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    public int getFlightId() { return flightId; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public double getPrice() { return price; }

    public void displayInfo() {
        System.out.println("Flight ID: " + flightId + 
                           ", Source: " + source + 
                           ", Destination: " + destination + 
                           ", Price: $" + price);
    }
}

// Booking class
class Booking {
    private int bookingId;
    private Flight flight;
    private String customerName;

    public Booking(int bookingId, Flight flight, String customerName) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.customerName = customerName;
    }

    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId + 
                           ", Customer: " + customerName);
        flight.displayInfo();
    }

    public int getBookingId() {
        return bookingId;
    }
}

// FlightBookingSystem class
public class FlightBookingSystem {
    private static Flight[] flights; // Array to store flights
    private static List<Booking> bookings = new ArrayList<>(); // List for bookings
    private static int bookingCounter = 1;

    // Initialize flights
    static {
        flights = new Flight[] {
            new Flight(1, "Delhi", "Mumbai", 5000),
            new Flight(2, "Delhi", "Bangalore", 6000),
            new Flight(3, "Mumbai", "Chennai", 4500),
            new Flight(4, "Kolkata", "Delhi", 5500)
        };
    }

    // Method: Search flights (case-insensitive)
    public static void searchFlights(String source, String destination) {
        System.out.println("Searching flights from " + source + " to " + destination + "...");
        boolean found = false;
        for (Flight f : flights) {
            if (f.getSource().equalsIgnoreCase(source) && 
                f.getDestination().equalsIgnoreCase(destination)) {
                f.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found!");
        }
    }

    // Method: Book flight
    public static void bookFlight(int flightId, String customerName) {
        for (Flight f : flights) {
            if (f.getFlightId() == flightId) {
                Booking b = new Booking(bookingCounter++, f, customerName);
                bookings.add(b);
                System.out.println("Booking successful!");
                b.displayBooking();
                return;
            }
        }
        System.out.println("Invalid Flight ID!");
    }

    // Method: View all bookings
    public static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet!");
        } else {
            System.out.println("----- All Bookings -----");
            for (Booking b : bookings) {
                b.displayBooking();
                System.out.println("------------------------");
            }
        }
    }

    // CRUD: Delete booking
    public static void cancelBooking(int bookingId) {
        Iterator<Booking> it = bookings.iterator();
        while (it.hasNext()) {
            Booking b = it.next();
            if (b.getBookingId() == bookingId) {
                it.remove();
                System.out.println("Booking ID " + bookingId + " cancelled!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Flight Booking System ---");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Source: ");
                    String src = sc.nextLine();
                    System.out.print("Enter Destination: ");
                    String dest = sc.nextLine();
                    searchFlights(src, dest);
                    break;
                case 2:
                    System.out.print("Enter Flight ID to book: ");
                    int fid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String cname = sc.nextLine();
                    bookFlight(fid, cname);
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.print("Enter Booking ID to cancel: ");
                    int bid = sc.nextInt();
                    cancelBooking(bid);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}