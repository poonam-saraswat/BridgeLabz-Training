/*4. Problem 4: Date Comparison Write a program that:
➢ Takes two date inputs and compares them to check if the first date is before, after,
or the same as the second date.
Hint: Use isBefore(), isAfter(), and isEqual() methods from the LocalDate
class.
 */
import java.util.*;
import java.time.*;

public class DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first date (yyyy-MM-dd): ");
        LocalDate firstDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter the second date (yyyy-MM-dd): ");
        LocalDate secondDate = LocalDate.parse(scanner.nextLine());

        if (firstDate.isBefore(secondDate)) {
            System.out.println("The first date is before the second date.");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("The first date is after the second date.");
        } else {
            System.out.println("The first date is the same as the second date.");
        }
    }
}