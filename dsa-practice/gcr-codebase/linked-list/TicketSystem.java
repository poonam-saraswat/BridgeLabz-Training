// Node class representing each Ticket
class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

// Circular Linked List Ticket Reservation System
class TicketReservationSystem {
    private TicketNode head = null;

    // Add a new ticket reservation at the end
    public void addTicket(int id, String customer, String movie, String seat, String time) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);
        if (head == null) {
            head = newNode;
            head.next = head; // circular link
        } else {
            TicketNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Ticket booked successfully for " + customer);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode temp = head, prev = null;
        do {
            if (temp.ticketId == id) {
                if (prev == null) { // removing head
                    TicketNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    if (head == head.next) { // only one node
                        head = null;
                    } else {
                        last.next = head.next;
                        head = head.next;
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Ticket with ID " + id + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket with ID " + id + " not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("[ID=" + temp.ticketId + ", Customer=" + temp.customerName +
                    ", Movie=" + temp.movieName + ", Seat=" + temp.seatNumber +
                    ", Time=" + temp.bookingTime + "]");
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name
    public void searchByCustomer(String customer) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(customer)) {
                System.out.println("Found Ticket: [ID=" + temp.ticketId + ", Customer=" + temp.customerName +
                        ", Movie=" + temp.movieName + ", Seat=" + temp.seatNumber +
                        ", Time=" + temp.bookingTime + "]");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for Customer " + customer);
        }
    }

    // Search for a ticket by Movie Name
    public void searchByMovie(String movie) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                System.out.println("Found Ticket: [ID=" + temp.ticketId + ", Customer=" + temp.customerName +
                        ", Movie=" + temp.movieName + ", Seat=" + temp.seatNumber +
                        ", Time=" + temp.bookingTime + "]");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for Movie " + movie);
        }
    }

    // Calculate total number of booked tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total Tickets: " + count);
    }
}

// Driver class
public class TicketSystem {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(2, "Bob", "Interstellar", "B2", "12:00 PM");
        system.addTicket(3, "Charlie", "Inception", "C3", "02:00 PM");

        System.out.println();
        system.displayTickets();

        System.out.println();
        system.searchByCustomer("Alice");

        System.out.println();
        system.searchByMovie("Inception");

        System.out.println();
        system.countTickets();

        System.out.println("\nRemoving Ticket ID 2:");
        system.removeTicket(2);

        System.out.println();
        system.displayTickets();
        system.countTickets();
    }
}
