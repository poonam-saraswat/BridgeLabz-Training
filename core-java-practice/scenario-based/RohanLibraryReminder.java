import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class RohanLibraryReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int FINE_PER_DAY = 5;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Book " + i + ":");
            System.out.print("Enter due date (yyyy-MM-dd): ");
            LocalDate dueDate = LocalDate.parse(scanner.nextLine());
            System.out.print("Enter return date (yyyy-MM-dd): ");
            LocalDate returnDate = LocalDate.parse(scanner.nextLine());

            long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
            if (daysLate > 0) {
                int fine = (int) daysLate * FINE_PER_DAY;
                System.out.println("You are late by " + daysLate + " days. Fine: ₹" + fine);
            } else {
                System.out.println("Book returned on time. No fine.");
            }
            System.out.println();
        }

        scanner.close();
    }
}