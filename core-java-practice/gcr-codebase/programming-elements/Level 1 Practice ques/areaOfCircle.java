import java.util.*;
public class areaOfCircle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of Circle:");
        double radius = sc.nextDouble();
        double area = Math.PI * radius * radius; //area calculation formula
        System.out.println("Area of the Circle is:" + area);
        sc.close();
       }
}