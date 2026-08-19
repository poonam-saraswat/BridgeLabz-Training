import java.util.*;

class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person(String firstName, String lastName, int idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    public void printPerson() {
        System.out.println("Name: " + lastName + ", " + firstName);
        System.out.println("ID: " + idNumber);
    }
}

class Student extends Person {
    private int[] testScores;

    // Constructor calls parent constructor using super(...)
    Student(String firstName, String lastName, int idNumber, int[] testScores) {
        super(firstName, lastName, idNumber); // initialize inherited fields
        this.testScores = testScores;
    }

    // Method to calculate grade
    public char calculate() {
        int sum = 0;
        for (int score : testScores) {
            sum += score;
        }
        int avg = sum / testScores.length;

        if (avg >= 90 && avg <= 100) return 'O'; // Outstanding
        else if (avg >= 80) return 'E'; // Exceeds Expectations
        else if (avg >= 70) return 'A'; // Acceptable
        else if (avg >= 55) return 'P'; // Poor
        else if (avg >= 40) return 'D'; // Dreadful
        else return 'T'; // Troll
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for (int i = 0; i < numScores; i++) {
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
    }
}
