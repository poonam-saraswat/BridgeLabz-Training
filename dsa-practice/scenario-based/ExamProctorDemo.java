import java.util.*;

class ExamProctor {
    private Stack<Integer> navigationStack;   // Track visited questions
    private HashMap<Integer, String> answers; // Store answers
    private HashMap<Integer, String> correctAnswers; // Correct answers for scoring

    public ExamProctor() {
        navigationStack = new Stack<>();
        answers = new HashMap<>();
        correctAnswers = new HashMap<>();

        // Pre-load correct answers (questionID → correctAnswer)
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "C");
        correctAnswers.put(3, "B");
        correctAnswers.put(4, "D");
    }

    // Navigate to a question
    public void visitQuestion(int questionID) {
        navigationStack.push(questionID);
        System.out.println("Visited Question " + questionID);
    }

    // Record answer
    public void recordAnswer(int questionID, String answer) {
        answers.put(questionID, answer);
        System.out.println("Answer recorded for Question " + questionID + ": " + answer);
    }

    // Show navigation history
    public void showNavigationHistory() {
        System.out.println("Navigation Stack (last visited on top): " + navigationStack);
    }

    // Evaluate score
    public int calculateScore() {
        int score = 0;
        for (Map.Entry<Integer, String> entry : answers.entrySet()) {
            int qID = entry.getKey();
            String ans = entry.getValue();
            if (correctAnswers.containsKey(qID) && correctAnswers.get(qID).equalsIgnoreCase(ans)) {
                score++;
            }
        }
        return score;
    }
}

public class ExamProctorDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExamProctor exam = new ExamProctor();

        int choice;
        do {
            System.out.println("\n--- ExamProctor Menu ---");
            System.out.println("1. Visit Question");
            System.out.println("2. Record Answer");
            System.out.println("3. Show Navigation History");
            System.out.println("4. Submit Exam & Calculate Score");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Question ID to visit: ");
                    int qID = sc.nextInt();
                    exam.visitQuestion(qID);
                    break;
                case 2:
                    System.out.print("Enter Question ID: ");
                    int qIDAns = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Answer (A/B/C/D): ");
                    String ans = sc.nextLine();
                    exam.recordAnswer(qIDAns, ans);
                    break;
                case 3:
                    exam.showNavigationHistory();
                    break;
                case 4:
                    int score = exam.calculateScore();
                    System.out.println("Exam Submitted! Final Score: " + score + "/" + 4);
                    break;
                case 5:
                    System.out.println("Exiting ExamProctor...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}