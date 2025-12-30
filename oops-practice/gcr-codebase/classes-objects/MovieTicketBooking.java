public class MovieTicketBooking {
    // Attributes
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean isBooked;

    // Constructor
    public MovieTicketBooking(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = false;
    }

    // Method to book a ticket
    public void bookTicket() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    // Method to display ticket details
    public void displayTicketDetails() {
        if (isBooked) {
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("Ticket have not booked yet....");
        }
    }

    // Main method to test the MovieTicket class
    public static void main(String[] args) {
        // Creating a MovieTicket object
        MovieTicketBooking ticket = new MovieTicketBooking("Dragon", "A10", 120.0);

        // Displaying ticket details before booking
        ticket.displayTicketDetails();

        // Booking the ticket
        ticket.bookTicket();

        // Trying to book the same ticket again
        ticket.bookTicket();

        // Displaying ticket details after booking
        ticket.displayTicketDetails();
    }
}
