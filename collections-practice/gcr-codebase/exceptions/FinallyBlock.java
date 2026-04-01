import java.util.Scanner;

public class FinallyBlock{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Take two integers from the user
            System.out.print("Enter the first integer: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second integer: ");
            int num2 = scanner.nextInt();

            // Step 2: Perform division
            int result = num1 / num2;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Step 3: Handle division by zero
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            // Step 4: Always executed
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}