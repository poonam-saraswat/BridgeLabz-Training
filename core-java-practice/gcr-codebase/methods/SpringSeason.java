import java.util.Scanner;
public class SpringSeason {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter day (1-31): ");
        int day = scanner.nextInt();

        // Check if it's spring season
        String result = checkSpringSeason(month, day);

        System.out.println(result);

        scanner.close();
    }

    // Method to check if the given date is in spring season
    public static String checkSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            return "It's a Spring Season";
        } else {
            return "Not a Spring Season";
        }
    }
}