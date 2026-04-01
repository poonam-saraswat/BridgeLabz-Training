package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

// Step 1: Define the annotation
@Retention(RetentionPolicy.RUNTIME)   // Available at runtime
@Target(ElementType.FIELD)            // Can be applied to fields only
@interface JsonField {
    String name();                    // Custom JSON key name
}

// Step 2: Apply annotation to a User class
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "email_address")
    private String email;

    private int age; // Not annotated, won't be serialized

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}

// Step 3: Serializer method
class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        boolean firstField = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true); // Access private fields
                JsonField annotation = field.getAnnotation(JsonField.class);

                try {
                    Object value = field.get(obj);
                    if (!firstField) {
                        jsonBuilder.append(", ");
                    }
                    jsonBuilder.append("\"")
                               .append(annotation.name())
                               .append("\": \"")
                               .append(value)
                               .append("\"");
                    firstField = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}

// Step 4: Test the annotation-based serializer
public class JsonFieldDemo {
    public static void main(String[] args) {
        User user = new User("Alice", "alice@example.com", 25);

        String json = JsonSerializer.toJson(user);
        System.out.println("Serialized JSON: " + json);
    }
}