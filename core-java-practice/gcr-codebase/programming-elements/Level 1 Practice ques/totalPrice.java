import java.util.*;
public class totalPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the unit price of the item:");
        double unitPrice = sc.nextDouble();
        System.out.println("Enter the quantity of the item:");
        int quantity = sc.nextInt();
        double totalPrice = unitPrice * quantity; //total price calculation formula
        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
        sc.close();
    }
    
}
