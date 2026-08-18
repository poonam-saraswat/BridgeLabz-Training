import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class CanYouAccess {
    public static void main(String[] args) {
        try {
            // Create an object of Inner.Private
            Inner.Private innerPrivate = new Inner().new Private();

            // Get the class object of Inner.Private
            Class<?> innerClass = innerPrivate.getClass();

            // Get the private method "powerof2" which takes an int parameter
            Method method = innerClass.getDeclaredMethod("powerof2", int.class);

            // Make the private method accessible
            method.setAccessible(true);

            // Invoke the method with argument 8
            String result = (String) method.invoke(innerPrivate, 8);

            // Print the result
            System.out.println(result);

            // Print the canonical name of the class
            System.out.println("An instance of class: " + innerClass.getCanonicalName() + " has been created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Inner {
    class Private {
        private String powerof2(int num) {
            return ((num & (num - 1)) == 0) ? "power of 2" : "not a power of 2";
        }
    }
}
