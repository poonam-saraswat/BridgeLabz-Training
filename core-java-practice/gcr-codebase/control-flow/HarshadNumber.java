import java.util.Scanner;
public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer to check if it is a Harshad number: ");
        int number = sc.nextInt();
        
        int originalNumber = number;
        int sum = 0;

        // Calculate the sum of digits
        while (originalNumber != 0) {
            int digit = originalNumber % 10; 
            sum += digit; 
            originalNumber /= 10;
        }

        // Check if the number is divisible by the sum of its digits
        if (number % sum == 0) {
            System.out.println(number + " is a Harshad number.");
        } else {
            System.out.println(number + " is not a Harshad number.");
        }

        sc.close();
    }
}