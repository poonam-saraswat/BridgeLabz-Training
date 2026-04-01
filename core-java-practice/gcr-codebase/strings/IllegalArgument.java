import java.util.Scanner;
public class IllegalArgument {
    public static void main(String[] args) {
        // Call the method that generates IllegalArgumentException
        System.out.println("Generating IllegalArgumentException:");
        generateIllegalArgumentException();

        // Call the method that handles IllegalArgumentException
        System.out.println("\nHandling IllegalArgumentException:");
        handleIllegalArgumentException();
    }

    // Method to generate IllegalArgumentException
    public static void generateIllegalArgumentException() {
        String text = "Hello, World!";
        // This will throw IllegalArgumentException
        System.out.println("Substring: " + text.substring(8, 5));
    }

    // Method to handle IllegalArgumentException
    public static void handleIllegalArgumentException() {
        String text = "Hello, World!";
        try {
            // Attempt to get substring with invalid indices
            System.out.println("Substring: " + text.substring(8, 5));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught an IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught a RuntimeException: " + e.getMessage());
        }
    }
}