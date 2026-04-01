import java.util.Scanner;
public class MaxOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter the third integer: ");
        int num3 = scanner.nextInt();


        int maxNumber = findMax(num1, num2, num3);
        System.out.printf("The maximum of %d, %d, and %d is %d%n", num1, num2, num3, maxNumber);

        scanner.close();
    }

    // Method to find the maximum of three numbers
    public static int findMax(int a, int b, int c) {
        int max = a; // Assume a is the maximum

        if (b > max) {
            max = b; // Update max if b is greater
        }
        if (c > max) {
            max = c; // Update max if c is greater
        }

        return max;
    }
}