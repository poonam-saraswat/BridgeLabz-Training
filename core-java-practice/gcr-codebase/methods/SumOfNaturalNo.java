import java.util.Scanner;
public class SumOfNaturalNo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer n to find the sum of first n natural numbers: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Please enter a positive integer greater than zero.");
        } else {
            int sum = calculateSumOfNaturalNumbers(n);
            System.out.printf("The sum of the first %d natural numbers is: %d%n", n, sum);
        }

        scanner.close();
    }

    // Method to calculate the sum of first n natural numbers
    public static int calculateSumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}