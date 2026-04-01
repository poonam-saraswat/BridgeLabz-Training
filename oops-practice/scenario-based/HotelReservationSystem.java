import java.util.*;

// Guest class (Encapsulation)
class Guest {
    private String guestId;
    private String name;

    public Guest(String guestId, String name) {
        this.guestId = guestId;
        this.name = name;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }
}

// Base Room class (OOP + Inheritance)
abstract class Room {
    private String roomNumber;
    private boolean isAvailable;

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public abstract double getBasePrice();
}

// DeluxeRoom subclass
class DeluxeRoom extends Room {
    public DeluxeRoom(String roomNumber) {
        super(roomNumber);
    }

    @Override
    public double getBasePrice() {
        return 5000.0; // base price for deluxe
    }
}

// StandardRoom subclass
class StandardRoom extends Room {
    public StandardRoom(String roomNumber) {
        super(roomNumber);
    }

    @Override
    public double getBasePrice() {
        return 2500.0; // base price for standard
    }
}

// Custom Exception
class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String message) {
        super(message);
    }
}

// Pricing Strategy Interface
interface PricingStrategy {
    double calculatePrice(Room room, int nights);
}

// Regular Pricing (Polymorphism)
class RegularPricing implements PricingStrategy {
    @Override
    public double calculatePrice(Room room, int nights) {
        return room.getBasePrice() * nights;
    }
}

// Seasonal Pricing (Polymorphism)
class SeasonalPricing implements PricingStrategy {
    @Override
    public double calculatePrice(Room room, int nights) {
        // Seasonal surcharge of 20%
        return room.getBasePrice() * nights * 1.2;
    }
}

// Reservation class
class Reservation {
    private Guest guest;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalAmount;

    public Reservation(Guest guest, Room room, Date checkInDate, Date checkOutDate, double totalAmount) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Reservation [Guest=" + guest.getName() + ", Room=" + room.getRoomNumber() +
                ", Amount=" + totalAmount + "]";
    }
}

// Hotel class (CRUD operations)
class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    // Add room
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Book reservation
    public Reservation bookRoom(Guest guest, Class<? extends Room> roomType,
                                Date checkIn, Date checkOut, PricingStrategy strategy)
            throws RoomNotAvailableException {

        for (Room room : rooms) {
            if (roomType.isInstance(room) && room.isAvailable()) {
                room.setAvailable(false);
                int nights = (int) ((checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24));
                double price = strategy.calculatePrice(room, nights);
                Reservation reservation = new Reservation(guest, room, checkIn, checkOut, price);
                reservations.add(reservation);
                System.out.println("✅ Reservation successful: " + reservation);
                return reservation;
            }
        }
        throw new RoomNotAvailableException("No available " + roomType.getSimpleName() + " rooms.");
    }

    // Check-out
    public void checkOut(Reservation reservation) {
        reservation.getRoom().setAvailable(true);
        System.out.println("🏨 Guest " + reservation.getGuest().getName() +
                " checked out. Room " + reservation.getRoom().getRoomNumber() + " is now available.");
    }

    // Generate invoice
    public void generateInvoice(Reservation reservation) {
        System.out.println("\n📄 Invoice:");
        System.out.println("Guest: " + reservation.getGuest().getName());
        System.out.println("Room: " + reservation.getRoom().getRoomNumber());
        System.out.println("Total Amount: ₹" + reservation.getTotalAmount());
    }
}

// Main class to test
public class HotelReservationSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        // Add rooms
        hotel.addRoom(new DeluxeRoom("D101"));
        hotel.addRoom(new StandardRoom("S201"));
        hotel.addRoom(new StandardRoom("S202"));

        // Create guest
        Guest guest1 = new Guest("G101", "Poonam");

        // Dates
        Calendar cal = Calendar.getInstance();
        Date checkIn = cal.getTime();
        cal.add(Calendar.DATE, 2);
        Date checkOut = cal.getTime();

        try {
            // Book room with seasonal pricing
            Reservation res1 = hotel.bookRoom(guest1, DeluxeRoom.class, checkIn, checkOut, new SeasonalPricing());

            // Generate invoice
            hotel.generateInvoice(res1);

            // Check-out
            hotel.checkOut(res1);

        } catch (RoomNotAvailableException e) {
            System.out.println("❌ Exception: " + e.getMessage());
        }
    }
}