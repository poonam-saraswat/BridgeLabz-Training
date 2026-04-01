import java.util.*;
public class studentFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the fee :");
        int fee = sc.nextInt();
        System.out.println("Enter the discount percentage :");
        int discountPercent = sc.nextInt();
        int discount = (fee * discountPercent) / 100; //discount calculation
        int finalFee = fee - discount;
        System.out.println("The discount amount is INR" + discount + " and final discounted fee is INR " + finalFee);
        sc.close();
    }
    
}
