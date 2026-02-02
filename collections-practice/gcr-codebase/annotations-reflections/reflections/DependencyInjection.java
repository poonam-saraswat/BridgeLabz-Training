package reflections;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

// Step 1: Define the @Inject annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject { }

// Step 2: Define some service classes
class ServiceA {
    public void doWork() {
        System.out.println("ServiceA is working...");
    }
}

class ServiceB {
    public void execute() {
        System.out.println("ServiceB is executing...");
    }
}

// Step 3: Define a client class that depends on services
class Client {
    @Inject
    private ServiceA serviceA;

    @Inject
    private ServiceB serviceB;

    public void run() {
        serviceA.doWork();
        serviceB.execute();
    }
}

// Step 4: Implement a simple DI container
class SimpleDIContainer {
    public static <T> T createInstance(Class<T> clazz) {
        try {
            // Create instance of the class
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Iterate over fields
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    // Create dependency instance
                    Object dependency = field.getType().getDeclaredConstructor().newInstance();

                    // Allow access to private fields
                    field.setAccessible(true);

                    // Inject dependency
                    field.set(obj, dependency);
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("DI failed: " + e.getMessage(), e);
        }
    }
}

// Step 5: Test the DI container
public class DependencyInjection {
    public static void main(String[] args) {
        // Create Client instance with dependencies injected
        Client client = SimpleDIContainer.createInstance(Client.class);

        // Run client logic
        client.run();
    }
}