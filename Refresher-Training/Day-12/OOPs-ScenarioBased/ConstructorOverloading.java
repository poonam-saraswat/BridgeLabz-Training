import java.util.*;

class Student {
    String name;
    int age;
    String course;

    // No-argument constructor
    public Student() {
        this("Unknown", 0, "Not assigned"); // delegates to full constructor
    }

    // Constructor with only name
    public Student(String name) {
        this(name, 18, "General Studies"); // delegates to full constructor
    }

    // Full constructor with all fields
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Method to display student details
    public void printDetails() {
        System.out.println("Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}

public class ConstructorOverloading {
    public static void main(String[] args) {
        // Create students using different constructors
        Student s1 = new Student(); // no-arg
        Student s2 = new Student("Poonam"); // name-only
        Student s3 = new Student("Aman", 22, "Computer Science"); // full

        // Print details of each student
        s1.printDetails();
        s2.printDetails();
        s3.printDetails();
    }
}
