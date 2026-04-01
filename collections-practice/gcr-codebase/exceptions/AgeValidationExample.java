import java.util.Scanner;

// Step 1: Define the custom exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidationExample {

    // Step 2: Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throw custom exception if age is below 18
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 3: Take user input
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Step 4: Call validateAge()
            validateAge(age);

        } catch (InvalidAgeException e) {
            // Step 5: Handle custom exception
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            System.out.println("Invalid input. Please enter a number.");
        } finally {
            scanner.close();
        }
    }
}