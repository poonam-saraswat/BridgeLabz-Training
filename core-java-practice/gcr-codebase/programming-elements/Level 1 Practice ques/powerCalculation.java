import java.util.*;
public class powerCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base number:");
        int base = sc.nextInt();
        System.out.println("Enter the exponent number:");
        int exponent = sc.nextInt();
        double power = Math.pow(base, exponent); //power calculation formula
        System.out.println(base + " raised to the power " + exponent + " is: " + power);
        sc.close();
    }
    
}
