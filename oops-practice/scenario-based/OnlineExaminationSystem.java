import java.util.*;

// Student class (Encapsulation)
class Student {
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

// Question class
class Question {
    private String questionText;
    private String correctAnswer;
    private boolean isObjective; // true = objective, false = descriptive

    public Question(String questionText, String correctAnswer, boolean isObjective) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.isObjective = isObjective;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isObjective() {
        return isObjective;
    }
}

// Custom Exception
class ExamTimeExpiredException extends Exception {
    public ExamTimeExpiredException(String message) {
        super(message);
    }
}

// Interface for Evaluation (Abstraction)
interface EvaluationStrategy {
    int evaluate(Map<Question, String> answers);
}

// Objective Evaluation (Polymorphism)
class ObjectiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate(Map<Question, String> answers) {
        int score = 0;
        for (Map.Entry<Question, String> entry : answers.entrySet()) {
            Question q = entry.getKey();
            String ans = entry.getValue();
            if (q.isObjective() && q.getCorrectAnswer().equalsIgnoreCase(ans)) {
                score++;
            }
        }
        return score;
    }
}

// Descriptive Evaluation (Polymorphism)
class DescriptiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate(Map<Question, String> answers) {
        // For simplicity, give 1 mark for any descriptive answer submitted
        int score = 0;
        for (Map.Entry<Question, String> entry : answers.entrySet()) {
            Question q = entry.getKey();
            if (!q.isObjective() && entry.getValue() != null && !entry.getValue().isEmpty()) {
                score++;
            }
        }
        return score;
    }
}

// Exam class (CRUD operations)
class Exam {
    private String examId;
    private String title;
    private List<Question> questions;
    private List<Student> enrolledStudents;
    private Map<Student, Map<Question, String>> submissions;
    private Date endTime;

    public Exam(String examId, String title, Date endTime) {
        this.examId = examId;
        this.title = title;
        this.questions = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.submissions = new HashMap<>();
        this.endTime = endTime;
    }

    // Create question
    public void addQuestion(Question q) {
        questions.add(q);
    }

    // Enroll student
    public void enrollStudent(Student s) {
        enrolledStudents.add(s);
    }

    // Submit answers
    public void submitAnswers(Student s, Map<Question, String> answers) throws ExamTimeExpiredException {
        Date now = new Date();
        if (now.after(endTime)) {
            throw new ExamTimeExpiredException("Exam time has expired. Submission not allowed.");
        }
        submissions.put(s, answers);
        System.out.println("Answers submitted by " + s.getName());
    }

    // Generate result
    public void generateResult(Student s, EvaluationStrategy strategy) {
        Map<Question, String> answers = submissions.get(s);
        if (answers == null) {
            System.out.println("No submission found for " + s.getName());
            return;
        }
        int score = strategy.evaluate(answers);
        System.out.println("Result for " + s.getName() + ": " + score + " marks");
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

// Main class to test
public class OnlineExaminationSystem {
    public static void main(String[] args) {
        // Create exam with 1 minute duration
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 1);
        Exam exam = new Exam("E101", "Java Basics Exam", cal.getTime());

        // Add questions
        Question q1 = new Question("What is JVM?", "Java Virtual Machine", false);
        Question q2 = new Question("Java is platform independent? (yes/no)", "yes", true);
        exam.addQuestion(q1);
        exam.addQuestion(q2);

        // Enroll student
        Student s1 = new Student("S101", "Poonam");
        exam.enrollStudent(s1);

        // Student submits answers
        Map<Question, String> answers = new HashMap<>();
        answers.put(q1, "It executes Java bytecode");
        answers.put(q2, "yes");

        try {
            exam.submitAnswers(s1, answers);
        } catch (ExamTimeExpiredException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Evaluate using Objective strategy
        exam.generateResult(s1, new ObjectiveEvaluation());

        // Evaluate using Descriptive strategy
        exam.generateResult(s1, new DescriptiveEvaluation());
    }
}