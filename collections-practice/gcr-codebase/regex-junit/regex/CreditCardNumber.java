import java.util.regex.*;
import java.util.*;

public class CreditCardNumber{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String cardNumber = sc.nextLine();

        String regex = "^(4\\d{15}|5\\d{15})$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);

        if (matcher.matches()) {
            if (cardNumber.startsWith("4")) {
                System.out.println("Valid Visa card number");
            } else {
                System.out.println("Valid MasterCard number");
            }
        } else {
            System.out.println("Invalid credit card number");
        }
    }
}
