import java.util.*;
public class OddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int number = sc.nextInt();

        if (number < 1) {
            System.out.println("The number " + number + " is not a natural number.");
            sc.close();
            return;
        }

        int evenSize = number / 2 + 1;
        int oddSize = number / 2 + (number % 2 == 0 ? 0 : 1);
        int[] evenNumbers = new int[evenSize];
        int[] oddNumbers = new int[oddSize];
        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i;
            } else {
                oddNumbers[oddIndex++] = i;
            }
        }

        System.out.println("Even numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

        System.out.println("Odd numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}