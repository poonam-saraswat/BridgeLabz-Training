import java.util.Scanner;
public class StringIndex {
    public static void main(String[] args) {
        // Call the method that generates StringIndexOutOfBoundsException
        System.out.println("Generating StringIndexOutOfBoundsException:");
        generateStringIndexOutOfBoundsException();

        // Call the method that handles StringIndexOutOfBoundsException
        System.out.println("\nHandling StringIndexOutOfBoundsException:");
        handleStringIndexOutOfBoundsException();
    }

    // Method to generate StringIndexOutOfBoundsException
    public static void generateStringIndexOutOfBoundsException() {
        String text = "Hello, World!";
        // This will throw StringIndexOutOfBoundsException
        System.out.println("Character at index 20: " + text.charAt(20));
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleStringIndexOutOfBoundsException() {
        String text = "Hello, World!";
        try {
            // Attempt to access character at an invalid index
            System.out.println("Character at index 20: " + text.charAt(20));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught a StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}