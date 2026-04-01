package reflections;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define the interface
interface Greeting {
    void sayHello(String name);
    void sayGoodbye(String name);
}

// Step 2: Implement the interface
class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    @Override
    public void sayGoodbye(String name) {
        System.out.println("Goodbye, " + name + "!");
    }
}

// Step 3: Create a custom InvocationHandler for logging
class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log the method name before execution
        System.out.println("[LOG] Invoking method: " + method.getName());

        // Execute the actual method on the target object
        return method.invoke(target, args);
    }
}

// Step 4: Test the dynamic proxy
public class DynamicProxy {
    public static void main(String[] args) {
        // Create the real object
        Greeting greeting = new GreetingImpl();

        // Create proxy instance
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingInvocationHandler(greeting)
        );

        // Call methods via proxy
        proxyInstance.sayHello("Alice");
        proxyInstance.sayGoodbye("Bob");
    }
}