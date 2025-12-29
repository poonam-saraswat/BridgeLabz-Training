import java.util.Scanner;
public class BusRouteDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalDistance = 0.0;
        String continueJourney;

        do {
            System.out.print("Enter distance to next stop (in km): ");
            double distanceToNextStop = scanner.nextDouble();
            totalDistance += distanceToNextStop;

            System.out.printf("Total distance traveled so far: %.2f km%n", totalDistance);
            System.out.print("Do you want to get off at this stop? (yes/no): ");
            continueJourney = scanner.next();
        } while (continueJourney.equalsIgnoreCase("no"));

        System.out.printf("You have exited the bus. Total distance traveled: %.2f km%n", totalDistance);
        scanner.close();
    }
}
