import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Step 1: Define the annotation
@Retention(RetentionPolicy.RUNTIME)   // Available at runtime
@Target(ElementType.METHOD)           // Applied to methods
@interface RoleAllowed {
    String value();                   // Role required to access the method
}

// Step 2: Create a class with restricted methods
class SecureService {

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("User task executed successfully!");
    }

    public void openTask() {
        System.out.println("Open task executed by anyone.");
    }
}

// Step 3: Access control simulation
public class RoleAccess{
    public static void main(String[] args) throws Exception {
        SecureService service = new SecureService();

        // Simulate different users
        String currentUserRole1 = "ADMIN";
        String currentUserRole2 = "USER";
        String currentUserRole3 = "GUEST";

        System.out.println("=== Testing with ADMIN role ===");
        invokeWithRole(service, "adminTask", currentUserRole1);
        invokeWithRole(service, "userTask", currentUserRole1);

        System.out.println("\n=== Testing with USER role ===");
        invokeWithRole(service, "adminTask", currentUserRole2);
        invokeWithRole(service, "userTask", currentUserRole2);

        System.out.println("\n=== Testing with GUEST role ===");
        invokeWithRole(service, "adminTask", currentUserRole3);
        invokeWithRole(service, "openTask", currentUserRole3);
    }

    // Helper method to check role before invoking
    private static void invokeWithRole(Object obj, String methodName, String role) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);

                if (roleAllowed.value().equals(role)) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied! Role '" + role + 
                                       "' cannot execute method '" + methodName + "'");
                }
            } else {
                // No restriction, allow execution
                method.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}