import java.util.Scanner;
public class AreaOfCircle {
    private double radius;

    // Constructor to initialize radius
    public AreaOfCircle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Main method to test the Circle class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        AreaOfCircle circle = new AreaOfCircle(radius);

        double area = circle.calculateArea();
        double circumference = circle.calculateCircumference();

        System.out.printf("Area of circle: %.4f%n", area);
        System.out.printf("Circumference of circle: %.4f%n", circumference);

        scanner.close();
    }
}