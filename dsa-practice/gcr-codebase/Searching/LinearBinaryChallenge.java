import java.util.Arrays;
import java.util.Scanner;

public class LinearBinaryChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Step 2: Input array elements
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Step 3: Linear Search for first missing positive integer
        int missing = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missing);

        // Step 4: Input target for Binary Search
        System.out.print("Enter the target number to search: ");
        int target = scanner.nextInt();

        // Step 5: Sort array for Binary Search
        Arrays.sort(arr);

        // Step 6: Perform Binary Search
        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Target " + target + " found at sorted index: " + index);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }

        scanner.close();
    }

    // Method to find first missing positive integer using linear search idea
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        // Step A: Mark numbers <=0 or >n as out of range
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        // Step B: Mark presence using negative marking
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val <= n) {
                if (arr[val - 1] > 0) {
                    arr[val - 1] = -arr[val - 1];
                }
            }
        }

        // Step C: Find first positive index
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1; // missing positive
            }
        }

        return n + 1; // if all 1..n are present
    }

    // Standard Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid; // found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // not found
    }
}