import java.util.Scanner;
public class NumberFormat {
    public static void main(String[] args) {
        // Call the method that generates NumberFormatException
        System.out.println("Generating NumberFormatException:");
        generateNumberFormatException();

        // Call the method that handles NumberFormatException
        System.out.println("\nHandling NumberFormatException:");
        handleNumberFormatException();
    }

    // Method to generate NumberFormatException
    public static void generateNumberFormatException() {
        String text = "abc123";
        // This will throw NumberFormatException
        System.out.println("Parsed number: " + Integer.parseInt(text));
    }

    // Method to handle NumberFormatException
    public static void handleNumberFormatException() {
        String text = "abc123";
        try {
            // Attempt to parse number from invalid string
            System.out.println("Parsed number: " + Integer.parseInt(text));
        } catch (NumberFormatException e) {
            System.out.println("Caught a NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught a RuntimeException: " + e.getMessage());
        }
    }
}