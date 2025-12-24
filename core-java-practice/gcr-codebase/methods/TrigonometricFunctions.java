import java.util.Scanner;
public class TrigonometricFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an angle in degrees: ");
        double angleInDegrees = scanner.nextDouble();

        double[] trigFunctions = calculateTrigonometricFunctions(angleInDegrees);

        System.out.printf("For angle %.2f degrees:%n", angleInDegrees);
        System.out.printf("Sine: %.4f%n", trigFunctions[0]);
        System.out.printf("Cosine: %.4f%n", trigFunctions[1]);
        System.out.printf("Tangent: %.4f%n", trigFunctions[2]);

        scanner.close();
    }

    // Method to calculate various trigonometric functions
    public static double[] calculateTrigonometricFunctions(double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);

        return new double[]{sine, cosine, tangent};
    }
}