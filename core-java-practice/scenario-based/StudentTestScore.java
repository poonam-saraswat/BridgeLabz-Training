import java.util.Scanner;
public class StudentTestScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] scores = new int[n];
        int sum = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        // Input scores
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter score for student " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    int score = scanner.nextInt();
                    if (score >= 0) {
                        scores[i] = score;
                        sum += score;
                        if (score > highest) highest = score;
                        if (score < lowest) lowest = score;
                        break;
                    } else {
                        System.out.println("Invalid input. Score cannot be negative.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next(); // Clear invalid input
                }
            }
        }

        // Calculate average
        double average = (double) sum / n;
        System.out.printf("Average score: %.2f%n", average);
        System.out.println("Highest score: " + highest);
        System.out.println("Lowest score: " + lowest);

        // Display scores above average
        System.out.println("Scores above average:");
        for (int score : scores) {
            if (score > average) {
                System.out.println(score);
            }
        }

        scanner.close();
    }
}
