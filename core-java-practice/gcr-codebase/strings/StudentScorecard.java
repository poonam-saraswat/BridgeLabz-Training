import java.util.Random;

public class StudentScorecard {

    // Generate random 2-digit scores for PCM
    public static int[][] generateScores(int studentCount) {
        Random rand = new Random();
        int[][] scores = new int[studentCount][3]; // 3 subjects: Physics, Chemistry, Math

        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(41) + 60; // Random scores between 60 and 100
            }
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        int studentCount = scores.length;
        double[][] stats = new double[studentCount][3]; // total, average, percentage

        for (int i = 0; i < studentCount; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    public static String[] calculateGrades(double[][] stats) {
        String[] grades = new String[stats.length];

        for (int i = 0; i < stats.length; i++) {
            double percent = stats[i][2];
            if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B";
            else if (percent >= 60) grades[i] = "C";
            else if (percent >= 50) grades[i] = "D";
            else if (percent >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] stats, String[] grades) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-12s %-8s\n",
                "Student", "Physics", "Chemistry", "Math", "Total", "Average", "Percentage", "Grade");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student%-3d %-10d %-10d %-10d %-10.0f %-10.2f %-12.2f %-8s\n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2],
                    stats[i][0], stats[i][1], stats[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        int studentCount = 5; // You can change this number
        int[][] scores = generateScores(studentCount);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);
        displayScorecard(scores, stats, grades);
    }
}
