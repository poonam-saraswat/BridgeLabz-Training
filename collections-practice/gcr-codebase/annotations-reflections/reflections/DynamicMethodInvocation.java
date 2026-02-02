package reflections;
import java.lang.reflect.Method;
import java.util.Scanner;

// Step 1: Define the MathOperations class
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

// Step 2: Use Reflection to call methods dynamically
public class DynamicMethodInvocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathOperations mathOps = new MathOperations();

        // Accept method name and parameters from user
        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        try {
            // Get method reference dynamically
            Method method = MathOperations.class.getMethod(methodName, int.class, int.class);

            // Invoke method with user-provided arguments
            Object result = method.invoke(mathOps, num1, num2);

            // Display result
            System.out.println("Result of " + methodName + "(" + num1 + ", " + num2 + "): " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name: " + methodName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}