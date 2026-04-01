import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}
class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int[] getMarks() {
        return marks;
    }
}
public class StudentReportGenerator {
    private List<Student> students;

    public StudentReportGenerator() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, int[] marks) throws InvalidMarkException {
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Marks should be between 0 and 100.");
            }
        }
        students.add(new Student(name, marks));
    }

    public double calculateAverage(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / (double) marks.length;
    }

    public String assignGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    public void displayReport() {
        for (Student student : students) {
            System.out.println("Report Card for: " + student.getName());
            int[] marks = student.getMarks();
            for (int i = 0; i < marks.length; i++) {
                System.out.println("Subject " + (i + 1) + ": " + marks[i]);
            }
            double average = calculateAverage(marks);
            String grade = assignGrade(average);
            System.out.printf("Average: %.2f\n", average);
            System.out.println("Grade: " + grade);
            System.out.println("-------------------------");
        }
    }
    public static void main(String[] args) {
        StudentReportGenerator reportGenerator = new StudentReportGenerator();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter number of students: ");
            int numberOfStudents = scanner.nextInt();

            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("Enter name of student " + (i + 1) + ": ");
                String name = scanner.next();

                System.out.print("Enter number of subjects for " + name + ": ");
                int numberOfSubjects = scanner.nextInt();
                int[] marks = new int[numberOfSubjects];

                for (int j = 0; j < numberOfSubjects; j++) {
                    System.out.print("Enter marks for subject " + (j + 1) + ": ");
                    marks[j] = scanner.nextInt();
                }

                reportGenerator.addStudent(name, marks);
            }

            reportGenerator.displayReport();
        } catch (InvalidMarkException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}