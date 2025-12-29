import java.util.Scanner;
public class GCDandLCMCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);

        System.out.printf("The GCD of %d and %d is %d%n", num1, num2, gcd);
        System.out.printf("The LCM of %d and %d is %d%n", num1, num2, lcm);

        scanner.close();
    }

    // Method to calculate GCD using Euclidean algorithm
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to calculate LCM
    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}