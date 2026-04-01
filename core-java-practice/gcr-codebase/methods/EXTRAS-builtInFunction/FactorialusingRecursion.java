import java.util.Scanner;
public class FactorialusingRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer to calculate its factorial: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long factorial = calculateFactorial(number);
            System.out.printf("The factorial of %d is %d%n", number, factorial);
        }

        scanner.close();
    }

    // Recursive method to calculate factorial
    public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case: factorial of 0 or 1 is 1
        }
        return n * calculateFactorial(n - 1); // Recursive case
    }
}