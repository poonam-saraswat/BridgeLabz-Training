import java.util.ArrayList;
import java.util.List;
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}
public class ResultProcessor {
    private String[] correctAnswers;
    private List<Integer> userScores;

    public ResultProcessor(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
        this.userScores = new ArrayList<>();
    }

    public int calculateScore(String[] userAnswers) throws InvalidQuizSubmissionException {
        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException("Answer length mismatch.");
        }
        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        userScores.add(score);
        return score;
    }

    public String getGrade(int score) {
        int totalQuestions = correctAnswers.length;
        double percentage = (score / (double) totalQuestions) * 100;

        if (percentage >= 90) return "A";
        else if (percentage >= 80) return "B";
        else if (percentage >= 70) return "C";
        else if (percentage >= 60) return "D";
        else return "F";
    }

    public List<Integer> getUserScores() {
        return userScores;
    }
}
class ResultProcessorTest {
    public static void main(String[] args) {
        String[] correctAnswers = {"A", "C", "B", "D", "A"};
        ResultProcessor processor = new ResultProcessor(correctAnswers);

        String[] user1Answers = {"A", "C", "B", "D", "A"};
        String[] user2Answers = {"A", "B", "B", "D", "C"};
        String[] user3Answers = {"A", "C", "B"}; // Invalid length

        try {
            int score1 = processor.calculateScore(user1Answers);
            System.out.println("User 1 Score: " + score1 + ", Grade: " + processor.getGrade(score1));

            int score2 = processor.calculateScore(user2Answers);
            System.out.println("User 2 Score: " + score2 + ", Grade: " + processor.getGrade(score2));

            // This will throw an exception
            int score3 = processor.calculateScore(user3Answers);
            System.out.println("User 3 Score: " + score3 + ", Grade: " + processor.getGrade(score3));
        } catch (InvalidQuizSubmissionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("All User Scores: " + processor.getUserScores());
    }
}
