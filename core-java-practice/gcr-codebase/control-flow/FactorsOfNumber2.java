import java.util.*;
public class FactorsOfNumber2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive integer to find its factors:");
        int number = sc.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            System.out.println("The factors of " + number + " are:");
            int i = 1;
            while (i <= number) {
                if (number % i == 0) {
                    System.out.println(i);
                }
                i++;
            }
        }
    }
}