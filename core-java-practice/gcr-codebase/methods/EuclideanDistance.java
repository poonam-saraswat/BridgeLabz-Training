import java.util.Scanner;
public class EuclideanDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1 and y1: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.print("Enter x2 and y2: ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance between (%d, %d) and (%d, %d) is: %.2f%n",
                x1, y1, x2, y2, distance);

        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        System.out.printf("Equation of the line: y = %.2fx + %.2f%n", lineEquation[0], lineEquation[1]);

        scanner.close();
    }

    // Method to calculate Euclidean distance between two points
    public static double calculateEuclideanDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to find the equation of the line given two points
    public static double[] findLineEquation(int x1, int y1, int x2, int y2) {
        double m = (double)(y2 - y1) / (x2 - x1); // slope
        double b = y1 - m * x1; // y-intercept
        return new double[]{m, b};
    }
}