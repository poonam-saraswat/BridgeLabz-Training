import java.util.Scanner;
public class SandeepFitnessTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pushUps = new int[7];

        // Input push-up counts for each day
        for (int i = 0; i < 7; i++) {
            System.out.print("Enter push-ups for day " + (i + 1) + " (0 if rest day): ");
            pushUps[i] = scanner.nextInt();
        }

        int totalPushUps = 0;
        int activeDays = 0;

        // Calculate total and average using for-each loop
        for (int count : pushUps) {
            if (count == 0) {
                continue; // Skip rest days
            }
            totalPushUps += count;
            activeDays++;
        }

        double averagePushUps = activeDays > 0 ? (double) totalPushUps / activeDays : 0;

        System.out.println("Total push-ups in the week: " + totalPushUps);
        System.out.printf("Average push-ups on active days: %.2f%n", averagePushUps);

        scanner.close();
    }
}
