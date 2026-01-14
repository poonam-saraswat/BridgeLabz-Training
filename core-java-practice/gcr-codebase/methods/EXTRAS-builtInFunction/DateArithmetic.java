/*2. Problem 2: Date Arithmetic Create a program that:
➢ Takes a date input and adds 7 days, 1 month, and 2 years to it.
➢ Then subtracts 3 weeks from the result.
Hint: Use LocalDate.plusDays(), plusMonths(), plusYears(), and
minusWeeks() methods.
 */
import java.util.*;
import java.time.*;

public class DateArithmetic {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Original Date: " + currentDate);

        LocalDate afterAdding = currentDate.plusDays(7).plusMonths(1).plusYears(2);
        System.out.println("After adding 7 days, 1 month, and 2 years: " + afterAdding);

        LocalDate finalDate = afterAdding.minusWeeks(3);
        System.out.println("Final Date (after subtracting 3 weeks): " + finalDate);
    }
}
