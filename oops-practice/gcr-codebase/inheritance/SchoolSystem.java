class Person {
    String name;
    int age;

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display person information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Teacher extends Person {
    String subject;

    // Parameterized constructor
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // Method to display role information
    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}
class Student extends Person {
    String grade;

    // Parameterized constructor
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    // Method to display role information
    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}
class Staff extends Person {
    String department;

    // Parameterized constructor
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    // Method to display role information
    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}
public class SchoolSystem {
    public static void main(String[] args) {
        // Creating a Teacher object
        Teacher teacher = new Teacher("Alice Johnson", 35, "Mathematics");
        System.out.println("Teacher Information:");
        teacher.displayInfo();
        teacher.displayRole();
        System.out.println();

        // Creating a Student object
        Student student = new Student("Bob Smith", 16, "10th Grade");
        System.out.println("Student Information:");
        student.displayInfo();
        student.displayRole();
        System.out.println();

        // Creating a Staff object
        Staff staff = new Staff("Carol White", 45, "Administration");
        System.out.println("Staff Information:");
        staff.displayInfo();
        staff.displayRole();
    }
}
