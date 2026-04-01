package reflections;

import java.lang.reflect.Field;

// Step 1: Define the Configuration class
class Configuration {
    private static String API_KEY = "DEFAULT_KEY";  // private static field

    public static void printKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

// Step 2: Use Reflection to access and modify the static field
public class StaticFieldReflection {
    public static void main(String[] args) {
        try {
            // Print original value
            Configuration.printKey();  // Output: API_KEY: DEFAULT_KEY

            // Get the 'API_KEY' field reference
            Field field = Configuration.class.getDeclaredField("API_KEY");

            // Allow access to private field
            field.setAccessible(true);

            // Modify the static field value (pass null for static fields)
            field.set(null, "NEW_SECRET_KEY");

            // Print updated value
            Configuration.printKey();  // Output: API_KEY: NEW_SECRET_KEY

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}