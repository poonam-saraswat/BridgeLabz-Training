/*An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete
Hint => 
Take user input for 3 sides of a triangle 
The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter
Write a Method to compute the number of rounds user needs to do to complete 5km run
 */
import java.util.Scanner;
public class AthleteRuns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side 1 of the triangular park (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter side 2 of the triangular park (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter side 3 of the triangular park (in meters): ");
        double side3 = scanner.nextDouble();

        // Calculate number of rounds needed to complete 5 km
        int rounds = calculateRounds(side1, side2, side3);

        System.out.printf("The athlete needs to complete %d rounds to run 5 km.%n", rounds);

        scanner.close();
    }

    // Method to calculate number of rounds needed to complete 5 km
    public static int calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3; // Perimeter in meters
        double distanceToRun = 5000; // 5 km in meters
        return (int) Math.ceil(distanceToRun / perimeter);
    }
}