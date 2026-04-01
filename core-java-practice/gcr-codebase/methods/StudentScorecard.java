import java.util.Scanner;
public class StudentScorecard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        int[][] scores = generateRandomScores(numberOfStudents);
        double[][] results = calculateTotalAveragePercentage(scores);
        displayScorecard(scores, results);

        scanner.close();
    }

    // Method to generate random 2-digit scores for Physics, Chemistry, and Math
    public static int[][] generateRandomScores(int n) {
        int[][] scores = new int[n][3]; // [][0] = Physics, [][1] = Chemistry, [][2] = Math

        for (int i = 0; i < n; i++) {
            scores[i][0] = (int) (10 + Math.random() * 90); // Physics
            scores[i][1] = (int) (10 + Math.random() * 90); // Chemistry
            scores[i][2] = (int) (10 + Math.random() * 90); // Math
        }

        return scores;
    }

    // Method to calculate total, average, and percentage for each student
    public static double[][] calculateTotalAveragePercentage(int[][] scores) {
        double[][] results = new double[scores.length][3]; // [][0] = Total, [][1] = Average, [][2] = Percentage

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0; // Round to 2 digits
            results[i][2] = Math.round(percentage * 100.0) / 100.0; // Round to 2 digits
        }

        return results;
    }

    // Method to display the scorecard of all students
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s%n", "Student", "Physics", "Chemistry", "Math", "Total", "Average", "Percentage");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-10.2f%n",
                    (i + 1),
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    results[i][0],
                    results[i][1],
                    results[i][2]);
        }
    }
}