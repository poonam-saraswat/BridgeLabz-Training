import java.util.Scanner;
public class PositiveEvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Taking user input for 5 numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Checking each number for positive/negative and even/odd
        for (int number : numbers) {
            if (isPositive(number)) {
                if (isEven(number)) {
                    System.out.println(number + " is positive and even.");
                } else {
                    System.out.println(number + " is positive and odd.");
                }
            } else {
                System.out.println(number + " is negative.");
            }
        }

        // Comparing the first and last elements
        int comparisonResult = compare(numbers[0], numbers[numbers.length - 1]);
        if (comparisonResult == 1) {
            System.out.println("The first number is greater than the last number.");
        } else if (comparisonResult == -1) {
            System.out.println("The first number is less than the last number.");
        } else {
            System.out.println("The first number is equal to the last number.");
        }

        scanner.close();
    }

    // Method to check whether the number is positive
    public static boolean isPositive(int num) {
        return num >= 0;
    }

    // Method to check whether the number is even
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // Method to compare two numbers
    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1; // num1 is greater
        } else if (num1 < num2) {
            return -1; // num1 is less
        } else {
            return 0; // both are equal
        }
    }
}