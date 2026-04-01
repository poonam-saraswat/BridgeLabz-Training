import java.util.Scanner;
public class NullPointerExceptionDemo {
    public static void main(String[] args) {
        // Call the method that generates NullPointerException
        System.out.println("Generating NullPointerException:");
        generateNullPointerException();

        // Call the method that handles NullPointerException
        System.out.println("\nHandling NullPointerException:");
        handleNullPointerException();
    }

    // Method to generate NullPointerException
    public static void generateNullPointerException() {
        String text = null;
        // This will throw NullPointerException
        System.out.println("Length of the string: " + text.length());
    }

    // Method to handle NullPointerException
    public static void handleNullPointerException() {
        String text = null;
        try {
            // Attempt to access length of null string
            System.out.println("Length of the string: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException: " + e.getMessage());
        }
    }
}