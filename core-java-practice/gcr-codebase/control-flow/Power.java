import java.util.*;
public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive integer for the base number:");
        int number = sc.nextInt();
        System.out.println("Enter a positive integer for the power:");
        int power = sc.nextInt();
        
        if (number <= 0 || power < 0) {
            System.out.println("Please enter positive integers for both base number and power.");
        } else {
            int result = 1;
            int counter = 0;
            while (counter < power) {
                result *= number;
                counter++;
            }
            System.out.println(number + " raised to the power of " + power + " is: " + result);
        }
    }
}