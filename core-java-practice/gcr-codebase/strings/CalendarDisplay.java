import java.util.Scanner;

public class CalendarDisplay {

    // Method to get month name
    public static String getMonthName(int month) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[month - 1];
    }

    // Method to check for leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to get number of days in a month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    // Method to get the first day of the month using Gregorian calendar algorithm
    public static int getFirstDayOfMonth(int month, int year) {
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0; // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    }

    // Method to display the calendar
    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int days = getDaysInMonth(month, year);
        int startDay = getFirstDayOfMonth(month, year);

        System.out.println("\n" + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // First loop for indentation
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Second loop to print days
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        displayCalendar(month, year);
    }
}
