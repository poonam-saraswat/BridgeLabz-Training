import java.util.Scanner;
public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = sc.nextInt();
        int tempNumber = number;
        int digitCount = 0;
        while (tempNumber != 0) {
            digitCount++;
            tempNumber /= 10;
        }

        int[] digits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        int[] frequency = new int[10];
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }

        System.out.println("Digit frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }

        sc.close();
    }
}