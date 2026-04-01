
import java.util.*;
public class FactorsOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to find its factors: ");
        int number = scanner.nextInt();

        int[] factors = Factors.findFactors(number);

        System.out.println("Factors of " + number + ": " + Arrays.toString(factors));

        int sum = Factors.calculateSum(factors);
        int product = Factors.calculateProduct(factors);
        int sumOfSquares = Factors.calculateSumOfSquares(factors);

        System.out.println("Sum of factors: " + sum);
        System.out.println("Product of factors: " + product);
        System.out.println("Sum of squares of factors: " + sumOfSquares);

        scanner.close();
    }
}
// Note: The actual methods for finding factors, calculating sum, product, and sum of squares are implemented in the Factors class.
