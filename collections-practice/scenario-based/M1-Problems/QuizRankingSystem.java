package M1-Problems;
import java.util.*;

class Student {
    String name;
    String department;
    int q1, q2, q3;
    int total;
    long order; // recording order

    Student(String name, String department, int q1, int q2, int q3, long order) {
        this.name = name;
        this.department = department;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.total = q1 + q2 + q3;
        this.order = order;
    }
}

public class QuizRankingSystem {
    private static List<Student> students = new ArrayList<>();
    private static long orderCounter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String command = parts[0];

            switch (command) {
                case "Record":
                    handleRecord(parts);
                    break;
                case "Top":
                    handleTop(parts);
                    break;
            }
        }
        sc.close();
    }

    private static void handleRecord(String[] parts) {
        String name = parts[1];
        String dept = parts[2];
        int q1 = Integer.parseInt(parts[3]);
        int q2 = Integer.parseInt(parts[4]);
        int q3 = Integer.parseInt(parts[5]);

        students.add(new Student(name, dept, q1, q2, q3, ++orderCounter));
        System.out.println("Record Added: " + name);
    }

    private static void handleTop(String[] parts) {
        if (students.isEmpty()) {
            System.out.println("No Records Available");
            return;
        }

        if (parts[1].equalsIgnoreCase("Q1") ||
            parts[1].equalsIgnoreCase("Q2") ||
            parts[1].equalsIgnoreCase("Q3")) {
            handleTopQuiz(parts[1]);
        } else {
            handleTopDepartment(parts[1]);
        }
    }

    private static void handleTopDepartment(String dept) {
        List<Student> deptStudents = new ArrayList<>();
        for (Student s : students) {
            if (s.department.equalsIgnoreCase(dept)) {
                deptStudents.add(s);
            }
        }

        if (deptStudents.isEmpty()) {
            System.out.println("Department Not Found");
            return;
        }

        int maxScore = deptStudents.stream().mapToInt(s -> s.total).max().orElse(0);

        for (Student s : deptStudents) {
            if (s.total == maxScore) {
                System.out.println(s.name + " " + s.total);
            }
        }
    }

    private static void handleTopQuiz(String quizName) {
        int quizIndex = quizName.equalsIgnoreCase("Q1") ? 1 :
                        quizName.equalsIgnoreCase("Q2") ? 2 : 3;

        int maxScore = 0;
        for (Student s : students) {
            int score = (quizIndex == 1 ? s.q1 : quizIndex == 2 ? s.q2 : s.q3);
            if (score > maxScore) maxScore = score;
        }

        for (Student s : students) {
            int score = (quizIndex == 1 ? s.q1 : quizIndex == 2 ? s.q2 : s.q3);
            if (score == maxScore) {
                System.out.println(s.name + " " + score);
            }
        }
    }
}