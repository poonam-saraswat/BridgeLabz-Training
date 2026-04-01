import java.util.Scanner;

public class ArrayOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Accept array size
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            // Step 2: Initialize array
            int[] arr = new int[size];

            // Step 3: Accept array elements
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            // Step 4: Accept index number
            System.out.print("Enter the index to retrieve: ");
            int index = scanner.nextInt();

            // Step 5: Retrieve and print value
            System.out.println("Value at index " + index + ": " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle invalid index
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            // Handle null array
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}