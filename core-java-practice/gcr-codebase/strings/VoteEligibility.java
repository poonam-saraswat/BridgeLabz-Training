import java.util.Scanner;
public class VoteEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        // Get random ages for n students
        int[] ages = generateRandomAges(n);

        // Get voting eligibility
        String[][] eligibility = checkVotingEligibility(ages);

        // Display the result
        displayEligibility(eligibility);

        scanner.close();
    }

    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = (int) (Math.random() * 90) + 1; // Random age between 1 and 90
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false"; // Negative age cannot vote
            } else if (ages[i] >= 18) {
                result[i][1] = "true"; // Can vote
            } else {
                result[i][1] = "false"; // Cannot vote
            }
        }
        return result;
    }

    public static void displayEligibility(String[][] eligibility) {
        System.out.printf("%-10s %-15s%n", "Age", "Can Vote");
        System.out.println("-----------------------");
        for (String[] entry : eligibility) {
            System.out.printf("%-10s %-15s%n", entry[0], entry[1]);
        }
    }
}