import java.util.Scanner;
public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dividend (number): ");
        int number = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Get quotient and remainder
        int[] result = findRemainderAndQuotient(number, divisor);
        int quotient = result[0];
        int remainder = result[1];

        System.out.printf("The quotient is %d and the remainder is %d%n", quotient, remainder);

        scanner.close();
    }

    // Method to find the quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }
}