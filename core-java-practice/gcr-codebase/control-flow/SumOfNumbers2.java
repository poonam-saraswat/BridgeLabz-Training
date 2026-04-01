import java.util.*;
public class SumOfNumbers2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double number;
        System.out.println("Enter numbers to sum (enter 0 or a negative number to stop):");
        while (true) {
            number = sc.nextDouble();
            if (number <= 0) {
                break;
            }
            total += number;
        }
        System.out.println("The sum of the entered numbers is: " + total);
    }
    
}