import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Step 1: Define the @Todo annotation
@Retention(RetentionPolicy.RUNTIME)   // Available at runtime for reflection
@Target(ElementType.METHOD)           // Can be applied to methods only
@interface Todo {
    String task();                    // Description of the task
    String assignedTo();              // Developer responsible
    String priority() default "MEDIUM"; // Optional field with default value
}

// Step 2: Apply annotation to multiple methods
class ProjectModule {

    @Todo(task = "Implement login functionality", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature code...");
    }

    @Todo(task = "Add payment gateway integration", assignedTo = "Bob")
    public void paymentFeature() {
        System.out.println("Payment feature code...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Charlie", priority = "LOW")
    public void optimizeDB() {
        System.out.println("Database optimization code...");
    }

    public void completedFeature() {
        System.out.println("This feature is already completed.");
    }
}

// Step 3: Retrieve and print all pending tasks using Reflection
public class TodoAnnotationDemo {
    public static void main(String[] args) {
        Class<ProjectModule> clazz = ProjectModule.class;

        // Iterate through all methods of ProjectModule
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("   Task: " + todo.task());
                System.out.println("   Assigned To: " + todo.assignedTo());
                System.out.println("   Priority: " + todo.priority());
                System.out.println("-----------------------------------");
            }
        }
    }
}