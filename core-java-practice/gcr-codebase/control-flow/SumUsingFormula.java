import java.util.*;
public class SumUsingFormula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int number = sc.nextInt();
        if (number < 1) {
            System.out.println("The number " + number + " is not a natural number.");
        } else {
            int sumUsingLoop = 0;
            for (int i = 1; i <= number; i++) {
                sumUsingLoop += i;
            }
            int sumUsingFormula = number * (number + 1) / 2;
            System.out.println("Sum using loop: " + sumUsingLoop);
            System.out.println("Sum using formula: " + sumUsingFormula);
            if (sumUsingLoop == sumUsingFormula) {
                System.out.println("Both computations are correct and equal.");
            } else {
                System.out.println("There is a discrepancy between the two computations.");
            }
        }
    }
}