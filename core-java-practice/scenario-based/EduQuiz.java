import java.util.Scanner;
public class EduQuiz {
    public static void main(String[] args) {
        String[] correctAnswers = {"A", "C", "B", "D", "A", "B", "C", "D", "A", "B"};
        String[] studentAnswers = new String[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your answers for the 10 questions (A, B, C, or D):");
        for (int i = 0; i < 10; i++) {
            System.out.print("Question " + (i + 1) + ": ");
            studentAnswers[i] = scanner.nextLine().trim();
        }

        int score = calculateScore(correctAnswers, studentAnswers);
        System.out.println("Your total score is: " + score + "/10");
        double percentage = (score / 10.0) * 100;
        System.out.printf("Percentage: %.2f%%\n", percentage);
        if (percentage >= 70) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }

        scanner.close();
    }

    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            if (student[i].equalsIgnoreCase(correct[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
                score++;
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
        return score;
    }
}
