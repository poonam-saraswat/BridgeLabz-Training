import java.util.Scanner;
public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of visitors: ");
        int numberOfVisitors = scanner.nextInt();

        for (int i = 1; i <= numberOfVisitors; i++) {
            System.out.print("Visitor " + i + ", enter your drawn number: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
                continue;
            }
            int drawnNumber = scanner.nextInt();

            if (drawnNumber % 3 == 0 && drawnNumber % 5 == 0) {
                System.out.println("Congratulations Visitor " + i + "! You win a gift!");
            } else {
                System.out.println("Sorry Visitor " + i + ", better luck next time.");
            }
        }

        scanner.close();
    }
}