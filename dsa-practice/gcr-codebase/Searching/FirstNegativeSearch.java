import java.util.Scanner;

public class FirstNegativeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take array size from user
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Step 2: Take array elements from user
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Step 3: Perform linear search for first negative number
        int index = -1; // default if not found
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                index = i;
                break; // stop at the first negative number
            }
        }

        // Step 4: Output result
        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
            System.out.println("Value: " + arr[index]);
        } else {
            System.out.println("No negative number found in the array.");
        }

        scanner.close();
    }
}