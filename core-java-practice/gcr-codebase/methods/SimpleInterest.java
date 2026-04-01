/*Write a program to input the Principal, Rate, and Time values and calculate Simple Interest.
Hint => 
Simple Interest = Principal * Rate * Time / 100
Take user input for principal, rate, time
Write a method to calculate the simple interest given principle, rate and time as parameters
Output “The Simple Interest is ___ for Principal ___, Rate of Interest ___ and Time ___”
 */
import java.util.Scanner;
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = scanner.nextDouble();

        // Calculate simple interest
        double simpleInterest = calculateSimpleInterest(principal, rate, time);

        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f%n",
                simpleInterest, principal, rate, time);

        scanner.close();
    }

    // Method to calculate simple interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
}