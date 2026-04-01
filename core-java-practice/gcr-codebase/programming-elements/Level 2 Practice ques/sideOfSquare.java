import java.util.*;
public class sideOfSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the perimeter of the Square");
        double perimeter = sc.nextInt();
        double side = perimeter / 4; //side calculation formula
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
        sc.close();
                    
    }
}
