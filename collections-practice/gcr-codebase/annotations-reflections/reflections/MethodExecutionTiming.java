package reflections;

import java.lang.reflect.Method;

// Step 1: Example class with methods
class SampleTasks {
    public void fastTask() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        System.out.println("FastTask result: " + sum);
    }

    public void slowTask() {
        long product = 1;
        for (int i = 1; i < 100000; i++) {
            product *= i % 100; // keep values manageable
        }
        System.out.println("SlowTask result: " + product);
    }
}

// Step 2: Reflection-based execution timing
public class MethodExecutionTiming {
    public static void main(String[] args) {
        try {
            // Load class dynamically
            Class<?> clazz = SampleTasks.class;
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // Iterate through all declared methods
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getParameterCount() == 0) { // only run no-arg methods
                    System.out.println("Executing method: " + method.getName());

                    long start = System.nanoTime();
                    method.invoke(obj);  // invoke method dynamically
                    long end = System.nanoTime();

                    long duration = end - start;
                    System.out.println("Execution time of " + method.getName() +
                                       ": " + duration + " nanoseconds");
                    System.out.println("-----------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}