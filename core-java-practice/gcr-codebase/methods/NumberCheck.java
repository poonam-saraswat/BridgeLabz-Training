import java.util.Scanner;
public class NumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        int result = checkNumber(number);

        if (result == 1) {
            System.out.println("The number is positive.");
        } else if (result == -1) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        scanner.close();
    }

    // Method to check whether the number is positive, negative, or zero
    public static int checkNumber(int num) {
        if (num > 0) {
            return 1; // Positive
        } else if (num < 0) {
            return -1; // Negative
        } else {
            return 0; // Zero
        }
    }
}