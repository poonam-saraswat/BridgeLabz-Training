import java.util.Scanner;
public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms for the Fibonacci sequence: ");
        int terms = scanner.nextInt();

        System.out.println("Fibonacci Sequence up to " + terms + " terms:");
        generateFibonacci(terms);

        scanner.close();
    }

    // Method to generate and print Fibonacci sequence
    public static void generateFibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}