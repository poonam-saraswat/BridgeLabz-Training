import java.util.*;
public class intOperation {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter a");
        int a = sc .nextInt();
        System.out.println("Enter b");
        int b = sc .nextInt();
        System.out.println("Enter c");
        int c = sc .nextInt();
        int operation1 = a + b * c; //operation 1 calculation
        int operation2 = a + b *c; //operation 2 calculation
        int operation3 = c + a / b; //operation 3 calculation
        int operation4 = a % b + c; //operation 4 calculation
        System.out.println("The results of Int Operations are " + operation1 + ", " + operation2 + ",  " + operation3 + ", and " + operation4);
                        
    }
    
}
