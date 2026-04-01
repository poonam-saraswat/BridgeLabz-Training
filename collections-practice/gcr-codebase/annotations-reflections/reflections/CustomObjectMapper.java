package reflections;

import java.lang.reflect.Field;
import java.util.Map;

// Step 1: Define the ObjectMapper utility
class ObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance using default constructor
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Iterate over all fields of the class
            for (Field field : clazz.getDeclaredFields()) {
                String fieldName = field.getName();

                if (properties.containsKey(fieldName)) {
                    field.setAccessible(true); // Allow access to private fields
                    Object value = properties.get(fieldName);

                    // Set the field value
                    field.set(obj, value);
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping object: " + e.getMessage(), e);
        }
    }
}

// Step 2: Example class to map
class Student {
    private String name;
    private int age;
    private String grade;

    // Default constructor required for Reflection
    public Student() {}

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", grade='" + grade + "'}";
    }
}

// Step 3: Test the custom object mapper
public class CustomObjectMapper {
    public static void main(String[] args) {
        Map<String, Object> properties = Map.of(
            "name", "Alice",
            "age", 20,
            "grade", "A"
        );

        Student student = ObjectMapper.toObject(Student.class, properties);
        System.out.println(student);
    }
}