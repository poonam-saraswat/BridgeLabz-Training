import java.util.*;
class Person {
    String name;
    int age;

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display person details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class PersonTest {
    public static void main(String[] args) {
        // Creating a Person object using parameterized constructor
        Person originalPerson = new Person("Alice", 30);
        System.out.println("Original Person:");
        originalPerson.displayDetails();

        // Creating a Person object using copy constructor
        Person clonedPerson = new Person(originalPerson);
        System.out.println("\nCloned Person:");
        clonedPerson.displayDetails();
    }
}