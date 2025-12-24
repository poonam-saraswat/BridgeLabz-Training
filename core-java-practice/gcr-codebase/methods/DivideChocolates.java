import java.util.Scanner;
public class DivideChocolates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        // Get chocolates per child and remaining chocolates
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
        int chocolatesPerChild = result[0];
        int remainingChocolates = result[1];

        System.out.printf("Each child will get %d chocolates and there will be %d remaining chocolates.%n",
                chocolatesPerChild, remainingChocolates);

        scanner.close();
    }

    // Method to find the number of chocolates each child gets and remaining chocolates
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int chocolatesPerChild = number / divisor;
        int remainingChocolates = number % divisor;
        return new int[]{chocolatesPerChild, remainingChocolates};
    }
}