public class StudentReport {
    // Attributes
    private String name;
    private String rollNumber;
    private double mark1;
    private double mark2;
    private double mark3;

    // Constructor
    public StudentReport(String name, String rollNumber, double mark1, double mark2, double mark3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    // Method to calculate grade based on marks
    public String calculateGrade() {
        double average = (mark1 + mark2 + mark3) / 3;
        if (average >= 85) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 50) {
            return "C";
        } else {
            return "D";
        }
    }

    // Method to display student details and grade
    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + mark1);
        System.out.println("Mark2: " + mark2);
        System.out.println("Mark3: " + mark3);
        System.out.println("Grade " + calculateGrade());
        System.out.println("----------------------------");
    }

    // Main method to test the StudentReport class
    public static void main(String[] args) {
        // Creating StudentReport objects
        StudentReport student1 = new StudentReport("Thamarai", "ECE001", 80.0, 70.0, 75.0);
        StudentReport student2 = new StudentReport("Kannan", "CSC002", 60.0, 65.0, 50.0);

        // Displaying student details and grades
        student1.displayStudentDetails();
        student2.displayStudentDetails();
    }
}