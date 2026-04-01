package reflections;

// Step 1: Define the Student class
class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display student info
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Step 2: Use Reflection to create instance dynamically
public class ReflectionCreate{
    public static void main(String[] args) {
        try {
            // Load the Student class dynamically
            Class<?> clazz = Class.forName("Student");

            // Get the constructor with parameters (String, int)
            java.lang.reflect.Constructor<?> constructor = clazz.getConstructor(String.class, int.class);

            // Create instance using reflection (no 'new' keyword)
            Object studentObj = constructor.newInstance("Alice", 20);

            // Cast to Student and call method
            Student student = (Student) studentObj;
            student.displayInfo();  // Output: Name: Alice, Age: 20

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}