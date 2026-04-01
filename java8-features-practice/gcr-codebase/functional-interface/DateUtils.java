import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface Date{
    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class DateUtils {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        System.out.println(
            Date.formatDate(today, "dd-MM-yyyy")
        );

        System.out.println(
            Date.formatDate(today, "MMM dd, yyyy")
        );
    }
}
