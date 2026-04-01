import java.util.*;
public class distanceInYardsMiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the distnace in feet:");
        double feet = sc.nextDouble();
        double yards = feet / 3; //conversion formula
        double miles = feet / 5280; //conversion formula
        System.out.println("The distance in yards is " + yards + " yards and in miles is " + miles + " miles for the given " + feet + " feet");
        sc.close();
    }
    
}
