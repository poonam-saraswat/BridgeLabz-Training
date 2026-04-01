package reflections;

import java.lang.reflect.Method;

// Step 1: Define the Calculator class
class Calculator {
    // Private method
    private int multiply(int a, int b) {
        return a * b;
    }
}

// Step 2: Use Reflection to invoke the private method
public class ReflectionInvoke{
    public static void main(String[] args) {
        try {
            // Create Calculator object
            Calculator calc = new Calculator();

            // Get the private method reference
            Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            // Allow access to private method
            method.setAccessible(true);

            // Invoke the method with arguments
            Object result = method.invoke(calc, 6, 7);

            // Display the result
            System.out.println("Result of multiply(6, 7): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}