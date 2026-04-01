import java.util.*;
public class MultiplesOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive integer less than 100:");
        int number = sc.nextInt();
        
        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
        } else {
            System.out.println("The multiples of " + number + " below 100 are:");
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.println(i);
                }
            }
        }
    }
}