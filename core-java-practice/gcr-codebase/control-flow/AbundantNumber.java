import java.util.Scanner;
public class AbundantNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer to check if it is an Abundant number: ");
        int number = sc.nextInt();
        
        int sum = 0;

        // Calculate the sum of divisors
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i; 
            }
        }

        // Check if the sum of divisors is greater than the number
        if (sum > number) {
            System.out.println(number + " is an Abundant number.");
        } else {
            System.out.println(number + " is not an Abundant number.");
        }

        sc.close();
    }
}