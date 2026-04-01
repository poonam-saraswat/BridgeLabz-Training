package reflections;

import java.lang.reflect.Field;

// Step 1: Define the Person class
class Person {
    private int age;  // private field

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

// Step 2: Use Reflection to access and modify private field
public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            // Create Person object
            Person person = new Person(25);
            person.displayAge();  // Output: Age: 25

            // Get the 'age' field using reflection
            Field ageField = Person.class.getDeclaredField("age");

            // Allow access to private field
            ageField.setAccessible(true);

            // Modify the value of 'age'
            ageField.set(person, 40);

            // Retrieve the modified value
            int updatedAge = (int) ageField.get(person);

            System.out.println("Updated Age (via reflection): " + updatedAge);

            // Display again using method
            person.displayAge();  // Output: Age: 40

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}