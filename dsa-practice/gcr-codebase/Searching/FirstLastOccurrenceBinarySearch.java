import java.util.Scanner;

public class FirstLastOccurrenceBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Step 2: Input array elements (sorted array)
        System.out.println("Enter " + n + " elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Step 3: Input target element
        System.out.print("Enter the target element: ");
        int target = scanner.nextInt();

        // Step 4: Find first and last occurrence
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);

        // Step 5: Output result
        if (first == -1 || last == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("First occurrence at index: " + first);
            System.out.println("Last occurrence at index: " + last);
        }

        scanner.close();
    }

    // Method to find first occurrence
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;      // record index
                right = mid - 1;   // keep searching left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Method to find last occurrence
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;      // record index
                left = mid + 1;    // keep searching right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}