import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // compareTo method defines natural ordering by score
    @Override
    public int compareTo(Student other) {
        return this.score - other.score; // ascending order
    }

    @Override
    public String toString() {
        return name + " (" + score + ")";
    }
}

public class GenericInterfaces {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 70));
        students.add(new Student("Charlie", 90));
        students.add(new Student("Diana", 75));

        // Sort using Collections.sort()
        Collections.sort(students);

        for (Student s : students) {
            System.out.println(s);
        }
    }
}
