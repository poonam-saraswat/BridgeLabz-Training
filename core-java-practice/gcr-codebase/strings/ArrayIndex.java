import java.util.Scanner;
public class ArrayIndex {
    public static void main(String[] args) {
        // Call the method that generates ArrayIndexOutOfBoundsException
        System.out.println("Generating ArrayIndexOutOfBoundsException:");
        generateArrayIndexOutOfBoundsException();

        // Call the method that handles ArrayIndexOutOfBoundsException
        System.out.println("\nHandling ArrayIndexOutOfBoundsException:");
        handleArrayIndexOutOfBoundsException();
    }

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateArrayIndexOutOfBoundsException() {
        String[] names = {"Alice", "Bob", "Charlie"};
        // This will throw ArrayIndexOutOfBoundsException
        System.out.println("Accessing index 5: " + names[5]);
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleArrayIndexOutOfBoundsException() {
        String[] names = {"Alice", "Bob", "Charlie"};
        try {
            // Attempt to access an invalid index
            System.out.println("Accessing index 5: " + names[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught a RuntimeException: " + e.getMessage());
        }
    }
}