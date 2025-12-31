import java.util.*;
class Circle {
    double radius;

    // Default constructor
    public Circle() {
        this(1.0); // Calls the parameterized constructor with default radius
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double area() {
        return Math.PI * radius * radius;
    }

    // Method to display circle details
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area());
    }
}
class CircleTest {
    public static void main(String[] args) {
        // Creating Circle object using default constructor
        Circle defaultCircle = new Circle();
        System.out.println("Default Circle:");
        defaultCircle.displayDetails();

        // Creating Circle object using parameterized constructor
        Circle customCircle = new Circle(5.0);
        System.out.println("\nCustom Circle:");
        customCircle.displayDetails();
    }
}