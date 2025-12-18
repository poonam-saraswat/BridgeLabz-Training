import java.util.*;
public class perimeterOfReactangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of Rectangle:");
        double length = sc.nextDouble();
        System.out.println("Enter the breadth of Rectangle:");
        double breadth = sc.nextDouble();
        double perimeter = 2 * (length + breadth); //perimeter calculation formula
        System.out.println("Perimeter of the Rectangle is:" + perimeter);
        sc.close();
       
        
    }
    
}
