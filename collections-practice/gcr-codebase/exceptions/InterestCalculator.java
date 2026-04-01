import java.util.Scanner;

public class InterestCalculator {

    // Method declaration with 'throws' to propagate exception
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            // 'throw' is used to actually throw the exception object
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        // Simple interest formula: (P * R * T) / 100
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Take user input
            System.out.print("Enter principal amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter rate of interest: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter number of years: ");
            int years = scanner.nextInt();

            // Call calculateInterest() which may throw exception
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            // Handle propagated exception
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}