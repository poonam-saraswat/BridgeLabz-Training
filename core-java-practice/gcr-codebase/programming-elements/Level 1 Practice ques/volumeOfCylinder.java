import java.util.*;
public class volumeOfCylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of Cylinder:");
        double radius = sc.nextDouble();
        System.out.println("Enter the height of Cylinder:");
        double height = sc.nextDouble();
        double volume = Math.PI * radius * radius * height; //volume calculation formula
        System.out.println("Volume of the Cylinder is:" + volume);

    }
    
}
