import java.util.Scanner;
public class CoffeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalBill = 0.0;
        final double GST_RATE = 0.07; // 7% GST

        while (true) {
            System.out.println("Enter coffee type (espresso, latte, cappuccino) or 'exit' to finish:");
            String coffeeType = sc.nextLine().toLowerCase();

            if (coffeeType.equals("exit")) {
                break;
            }

            System.out.println("Enter quantity:");
            int quantity = sc.nextInt();
            sc.nextLine();

            double pricePerCup;
            switch (coffeeType) {
                case "espresso":
                    pricePerCup = 3.0;
                    break;
                case "latte":
                    pricePerCup = 4.0;
                    break;
                case "cappuccino":
                    pricePerCup = 4.5;
                    break;
                default:
                    System.out.println("Invalid coffee type. Please try again.");
                    continue; // Skip to next iteration
            }

            double bill = pricePerCup * quantity;
            double gst = bill * GST_RATE;
            double totalForThisOrder = bill + gst;

            totalBill += totalForThisOrder;

            System.out.printf("Bill for %d %s(s): $%.2f (including $%.2f GST)%n", quantity, coffeeType, totalForThisOrder, gst);
        }

        System.out.printf("Total bill for all customers: $%.2f%n", totalBill);
        sc.close();
    }
}