import java.util.Scanner;

public class CollinearityCheck {

    // Method to check collinearity using slope formula
    public static boolean areCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        double slopeAB = (double)(y2 - y1) / (x2 - x1);
        double slopeBC = (double)(y3 - y2) / (x3 - x2);
        double slopeAC = (double)(y3 - y1) / (x3 - x1);
        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    // Method to check collinearity using area of triangle formula
    public static boolean areCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * Math.abs(
            x1 * (y2 - y3) +
            x2 * (y3 - y1) +
            x3 * (y1 - y2)
        );
        return area == 0.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input coordinates
        System.out.print("Enter x1 y1: ");
        int x1 = sc.nextInt(), y1 = sc.nextInt();
        System.out.print("Enter x2 y2: ");
        int x2 = sc.nextInt(), y2 = sc.nextInt();
        System.out.print("Enter x3 y3: ");
        int x3 = sc.nextInt(), y3 = sc.nextInt();

        // Check using slope method
        boolean slopeResult = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        System.out.println("Collinear by slope method: " + slopeResult);

        // Check using area method
        boolean areaResult = areCollinearByArea(x1, y1, x2, y2, x3, y3);
        System.out.println("Collinear by area method: " + areaResult);

        sc.close();
    }
}
