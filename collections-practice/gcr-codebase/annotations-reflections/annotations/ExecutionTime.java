package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Step 1: Define the annotation
@Retention(RetentionPolicy.RUNTIME)   // Available at runtime
@Target(ElementType.METHOD)           // Can be applied to methods only
@interface LogExecutionTime { }

// Step 2: Create a class with annotated methods
class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        // Simple loop
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        System.out.println("Fast method result: " + sum);
    }

    @LogExecutionTime
    public void slowMethod() {
        // Simulate heavy computation
        long product = 1;
        for (int i = 1; i < 100000; i++) {
            product *= i % 100;  // keep values manageable
        }
        System.out.println("Slow method result: " + product);
    }

    public void normalMethod() {
        System.out.println("This method is not annotated.");
    }
}

// Step 3: Runner class to measure execution time
public class ExecutionTime {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();

        // Iterate through all methods
        for (Method method : PerformanceTest.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(test);   // Execute the method
                long end = System.nanoTime();
                long duration = end - start;

                System.out.println("Execution time of " + method.getName() +
                                   ": " + duration + " nanoseconds");
                System.out.println("-----------------------------------");
            }
        }
    }
}