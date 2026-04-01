package reflections;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)   // Available at runtime
@Target(ElementType.TYPE)             // Can be applied to classes
@interface Author {
    String name();                    // Annotation field
}

// Step 2: Apply annotation to a class
@Author(name = "John Doe")
class Book {
    public void display() {
        System.out.println("This is a book class.");
    }
}

// Step 3: Retrieve annotation at runtime using Reflection
public class AnnotationRuntime {
    public static void main(String[] args) {
        // Get class reference
        Class<Book> clazz = Book.class;

        // Check if @Author is present
        if (clazz.isAnnotationPresent(Author.class)) {
            // Retrieve annotation
            Author author = clazz.getAnnotation(Author.class);

            // Display annotation value
            System.out.println("Author of class " + clazz.getSimpleName() + ": " + author.name());
        } else {
            System.out.println("No @Author annotation present on class " + clazz.getSimpleName());
        }
    }
}
