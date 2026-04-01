import java.util.Scanner;
public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double smartCardBalance = 500.0; // Initial balance

        while (true) {
            System.out.println("Current Smart Card Balance: ₹" + smartCardBalance);
            System.out.print("Enter travel distance in km (or -1 to exit): ");
            int distance = scanner.nextInt();

            if (distance == -1) {
                System.out.println("Exiting. Thank you for using the Metro Smart Card.");
                break;
            }

            // Calculate fare using ternary operator
            double fare = (distance <= 5) ? 20.0 :
                          (distance <= 15) ? 40.0 :
                          (distance <= 25) ? 60.0 : 80.0;

            if (fare > smartCardBalance) {
                System.out.println("Insufficient balance for this trip. Please recharge your card.");
                continue; // Skip to next iteration
            }

            // Deduct fare from balance
            smartCardBalance -= fare;
            System.out.println("Fare of ₹" + fare + " deducted for " + distance + " km trip.");

            if (smartCardBalance <= 0) {
                System.out.println("Your smart card balance is exhausted. Please recharge.");
                break; // Exit if balance is exhausted
            }
        }

        scanner.close();
    }
}
