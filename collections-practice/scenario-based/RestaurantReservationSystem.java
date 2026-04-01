import java.util.*;

// Custom Exception
class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}

// Table class
class Table {
    private int tableNumber;
    private int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableNumber=" + tableNumber +
                ", capacity=" + capacity +
                '}';
    }
}

// Reservation class
class Reservation {
    private Table table;
    private String customerName;
    private String timeSlot; // e.g. "7:00 PM - 9:00 PM"

    public Reservation(Table table, String customerName, String timeSlot) {
        this.table = table;
        this.customerName = customerName;
        this.timeSlot = timeSlot;
    }

    public Table getTable() {
        return table;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "table=" + table.getTableNumber() +
                ", customer='" + customerName + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                '}';
    }
}

// Restaurant class
class Restaurant {
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    // Add tables to restaurant
    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }

    // Reserve a table
    public void reserveTable(int tableNumber, String customerName, String timeSlot)
            throws TableAlreadyReservedException {

        Table table = tables.get(tableNumber);
        if (table == null) {
            System.out.println("Table " + tableNumber + " does not exist.");
            return;
        }

        // Check if already reserved for that time slot
        for (Reservation r : reservations) {
            if (r.getTable().getTableNumber() == tableNumber &&
                r.getTimeSlot().equals(timeSlot)) {
                throw new TableAlreadyReservedException(
                        "Table " + tableNumber + " is already reserved for " + timeSlot);
            }
        }

        Reservation reservation = new Reservation(table, customerName, timeSlot);
        reservations.add(reservation);
        System.out.println("Reservation successful: " + reservation);
    }

    // Cancel reservation
    public void cancelReservation(int tableNumber, String timeSlot) {
        reservations.removeIf(r -> r.getTable().getTableNumber() == tableNumber &&
                                   r.getTimeSlot().equals(timeSlot));
        System.out.println("Reservation for table " + tableNumber + " at " + timeSlot + " cancelled.");
    }

    // Show available tables for a given time slot
    public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");
        for (Table table : tables.values()) {
            boolean reserved = false;
            for (Reservation r : reservations) {
                if (r.getTable().getTableNumber() == table.getTableNumber() &&
                    r.getTimeSlot().equals(timeSlot)) {
                    reserved = true;
                    break;
                }
            }
            if (!reserved) {
                System.out.println(table);
            }
        }
    }
}

// Demo
public class RestaurantReservationSystem {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        // Add tables
        restaurant.addTable(new Table(1, 2));
        restaurant.addTable(new Table(2, 4));
        restaurant.addTable(new Table(3, 6));

        try {
            restaurant.reserveTable(1, "Alice", "7:00 PM - 9:00 PM");
            restaurant.reserveTable(2, "Bob", "7:00 PM - 9:00 PM");

            // Attempt double booking
            restaurant.reserveTable(1, "Charlie", "7:00 PM - 9:00 PM");
        } catch (TableAlreadyReservedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        restaurant.showAvailableTables("7:00 PM - 9:00 PM");

        restaurant.cancelReservation(2, "7:00 PM - 9:00 PM");
        restaurant.showAvailableTables("7:00 PM - 9:00 PM");
    }
}