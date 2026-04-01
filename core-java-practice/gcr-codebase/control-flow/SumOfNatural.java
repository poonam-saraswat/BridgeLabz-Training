import java.util.*;

public class SumOfNatural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = sc.nextInt();
        int sum = 0;
        if (number < 0) {
            System.out.println("The number " +  number + " is not a natural number.");
        } else {
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            System.out.println("The sum of " + number + " natural numbers is " + sum);
        }
    }
    
}
