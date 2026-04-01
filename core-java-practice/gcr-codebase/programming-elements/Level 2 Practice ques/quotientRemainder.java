import java.util.*;
public class quotientRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number1:");
        int number1 = sc.nextInt();
        System.out.println("Enter number2:");
        int number2 = sc.nextInt();
        int quotient = number1 / number2; //quotient calculation
        int remainder = number1 % number2; //remainder calculation
        System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder + " of two number " + number1 + " and " + number2);
    }
    
}
