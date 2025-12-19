import java.util.*;
public class BonusOfEmployees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the salary of the employee:");
        double salary = sc.nextDouble();
        System.out.println("Enter the years of service of the employee:");
        int yearsOfService = sc.nextInt();
        
        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("The bonus amount is: " + bonus);
        } else {
            System.out.println("No bonus awarded.");
        }
    }
    
}