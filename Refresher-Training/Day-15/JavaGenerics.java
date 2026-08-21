import java.util.*;

class Printer {
    // Generic method to print any type of array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

public class JavaGenerics{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read Integer array
        int n = sc.nextInt();
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = sc.nextInt();
        }

        // Read String array
        n = sc.nextInt();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = sc.next();
        }

        // Call generic method
        Printer.printArray(intArray);
        Printer.printArray(stringArray);
    }
}
