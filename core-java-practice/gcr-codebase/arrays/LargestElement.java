import java.util.Scanner;
public class LargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = sc.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        while (number != 0) {
            if (index == maxDigit) {
                break; // Stop if we reach the maximum size of the array
            }
            int digit = number % 10;
            digits[index] = digit;
            index++;
            number /= 10;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        if (secondLargest != Integer.MIN_VALUE) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("There is no second largest digit.");
        }

        sc.close();
    }
}