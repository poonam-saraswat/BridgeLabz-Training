import java.util.*;

public class doubleOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a");
        double a = sc.nextDouble();
        System.out.println("Enter b");
        double b = sc.nextDouble();
        System.out.println("Enter c");
        double c = sc.nextDouble();
        double operation1 = a + b * c; //operation 1 calculation
        double operation2 = a * b + c; //operation 2 calculation
        double operation3 = c + a / b; //operation 3 calculation
        double operation4 = a % b + c; //operation 4 calculation
        System.out.println("The results of Double Operations are " + operation1 + ", " + operation2 + ",  " + operation3 + ", and " + operation4);
    }
    
}
