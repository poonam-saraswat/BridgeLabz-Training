import java.util.*;
public class heightConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height in centimetres");
        double centimetres = sc.nextDouble();
        double inches = centimetres / 2.54; //conversion formula
        double feet = inches / 12; //conversion formula
        System.out.println("Your height in cm is " + centimetres + " while in feet is " + feet + " and inches is " + inches);
        sc.close();
    }
    
}
