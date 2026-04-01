import java.util.*;
public class distanceConvert2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter distance in kilometers:");
        double kilometers = sc.nextDouble();
        double miles = kilometers * 1.6; //conversion formula
        System.out.println("The total miles is" + miles + " mile for the given " + kilometers + " km" );
        sc.close();
    }
    
}
