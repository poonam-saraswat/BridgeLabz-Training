import java.util.Scanner;
public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueBooking;

        do {
            System.out.print("Enter movie type (1 for Action, 2 for Comedy, 3 for Drama): ");
            int movieType = scanner.nextInt();

            System.out.print("Enter seat type (1 for Gold, 2 for Silver): ");
            int seatType = scanner.nextInt();

            System.out.print("Do you want snacks? (yes/no): ");
            String wantsSnacks = scanner.next();

            double ticketPrice = calculateTicketPrice(movieType, seatType, wantsSnacks);
            System.out.printf("Total ticket price: $%.2f%n", ticketPrice);

            System.out.print("Do you want to book another ticket? (yes/no): ");
            continueBooking = scanner.next();
        } while (continueBooking.equalsIgnoreCase("yes"));

        scanner.close();
    }

    // Method to calculate ticket price based on selections
    public static double calculateTicketPrice(int movieType, int seatType, String wantsSnacks) {
        double basePrice = 0.0;

        // Determine base price based on movie type
        switch (movieType) {
            case 1: // Action
                basePrice = 15.0;
                break;
            case 2: // Comedy
                basePrice = 12.0;
                break;
            case 3: // Drama
                basePrice = 10.0;
                break;
            default:
                System.out.println("Invalid movie type selected.");
                return 0.0;
        }

        // Adjust price based on seat type
        if (seatType == 1) { // Gold
            basePrice += 5.0;
        } else if (seatType == 2) { // Silver
            basePrice += 2.0;
        } else {
            System.out.println("Invalid seat type selected.");
            return 0.0;
        }

        // Add snack cost if applicable
        if (wantsSnacks.equalsIgnoreCase("yes")) {
            basePrice += 7.0; // Flat snack price
        }

        return basePrice;
    }
}