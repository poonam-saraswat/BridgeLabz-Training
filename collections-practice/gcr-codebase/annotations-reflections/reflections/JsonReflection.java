package reflections;

import java.lang.reflect.Field;

// Step 1: Utility class for JSON conversion
class JsonUtil {
    public static String toJson(Object obj) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        
        Field[] fields = obj.getClass().getDeclaredFields();
        boolean firstField = true;

        for (Field field : fields) {
            field.setAccessible(true); // allow access to private fields
            try {
                Object value = field.get(obj);

                if (!firstField) {
                    jsonBuilder.append(", ");
                }

                jsonBuilder.append("\"")
                           .append(field.getName())
                           .append("\": ");

                // Handle different value types
                if (value instanceof String) {
                    jsonBuilder.append("\"").append(value).append("\"");
                } else {
                    jsonBuilder.append(value);
                }

                firstField = false;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}

// Step 2: Example class
class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
}

// Step 3: Test the JSON generator
public class JsonReflection {
    public static void main(String[] args) {
        Student student = new Student("Alice", 20, 3.8);

        String json = JsonUtil.toJson(student);
        System.out.println("JSON Representation: " + json);
    }
}