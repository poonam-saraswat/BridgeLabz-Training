package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the annotation
@Retention(RetentionPolicy.RUNTIME)   // Available at runtime
@Target(ElementType.METHOD)           // Applied to methods
@interface CacheResult { }

// Step 2: Class with an expensive method
class ExpensiveCalculator {

    // Cache storage
    private static final Map<Integer, Long> cache = new HashMap<>();

    @CacheResult
    public long factorial(int n) {
        System.out.println("Computing factorial for " + n + " ...");

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Method to invoke with caching logic
    public Object invokeWithCache(String methodName, Object... args) throws Exception {
        Method method = this.getClass().getMethod(methodName, int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            int input = (Integer) args[0];

            // Check cache first
            if (cache.containsKey(input)) {
                System.out.println("Returning cached result for " + input);
                return cache.get(input);
            }

            // Compute and store in cache
            Object result = method.invoke(this, args);
            cache.put(input, (Long) result);
            return result;
        } else {
            // No caching, just invoke
            return method.invoke(this, args);
        }
    }
}

// Step 3: Test the caching system
public class CacheDemo {
    public static void main(String[] args) throws Exception {
        ExpensiveCalculator calc = new ExpensiveCalculator();

        // First call - computes factorial
        System.out.println("Result: " + calc.invokeWithCache("factorial", 10));

        // Second call with same input - returns cached result
        System.out.println("Result: " + calc.invokeWithCache("factorial", 10));

        // Different input - computes again
        System.out.println("Result: " + calc.invokeWithCache("factorial", 12));
    }
}