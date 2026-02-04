package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)   // Keep annotation at runtime for reflection
@Target(ElementType.METHOD)           // Can only be applied to methods
@interface ImportantMethod {
    String level() default "HIGH";    // Optional parameter with default value
}

// Step 2: Apply annotation to methods
class TaskManager {

    @ImportantMethod(level = "HIGH")
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void regularTask() {
        System.out.println("Executing regular task...");
    }

    public void optionalTask() {
        System.out.println("Executing optional task...");
    }
}

// Step 3: Retrieve and print annotated methods using Reflection
public class AnnotationPractice {
    public static void main(String[] args) {
        Class<TaskManager> clazz = TaskManager.class;

        // Iterate through all methods of TaskManager
        for (Method method : clazz.getDeclaredMethods()) {
            // Check if method has @ImportantMethod annotation
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() +
                                   " | Importance Level: " + annotation.level());
            }
        }
    }
}