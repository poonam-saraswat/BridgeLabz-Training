import java.util.*;
public class simpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Principal amount:");
        double principal = sc.nextDouble();
        System.out.println("Enter Rate of interest:");
        double rate = sc.nextDouble();
        System.out.println("Enter Time in years:");
        double time = sc.nextDouble();
        double simpleInterest = (principal * rate * time) / 100; //simple interest formula
        System.out.println("Simple Interest is: " + simpleInterest);
        sc.close();
        
    }
    
}
