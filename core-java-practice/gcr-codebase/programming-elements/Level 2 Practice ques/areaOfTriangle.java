import java.util.*;
public class areaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base of Triangle:");
        double base = sc.nextDouble();
        System.out.println("Enter the height of Triangle:");
        double height = sc.nextDouble();
        double area = 0.5 * base * height; //area calculation formula
        System.out.println("Area of the Triangle is:" + area);
        sc.close();
    }
    
}
