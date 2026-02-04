package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

// Step 1: Define the annotation
@Retention(RetentionPolicy.RUNTIME)   // Available at runtime
@Target(ElementType.FIELD)            // Can be applied to fields only
@interface MaxLength {
    int value();                      // Maximum allowed length
}

// Step 2: Apply annotation to a User class field
class User {
    @MaxLength(10)   // Username must not exceed 10 characters
    private String username;

    // Constructor with validation
    public User(String username) {
        try {
            // Get the field reference
            Field field = this.getClass().getDeclaredField("username");

            // Check if @MaxLength is present
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);

                // Validate length
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                        "Username exceeds maximum length of " + maxLength.value()
                    );
                }
            }

            this.username = username;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

// Step 3: Test the annotation
public class MaxLengthDemo {
    public static void main(String[] args) {
        // Valid username
        User user1 = new User("Alice");
        System.out.println("User1: " + user1.getUsername());

        // Invalid username (exceeds 10 characters)
        try {
            User user2 = new User("VeryLongUsername123");
            System.out.println("User2: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}