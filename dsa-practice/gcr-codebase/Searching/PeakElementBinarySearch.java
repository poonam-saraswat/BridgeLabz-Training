import java.util.Scanner;

public class PeakElementBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Step 2: Input array elements
        System.out.println("Enter " + n + " elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Step 3: Find peak element using binary search
        int peakIndex = findPeakElement(arr);

        // Step 4: Output result
        System.out.println("Peak element found at index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);

        scanner.close();
    }

    // Method to find a peak element
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Check neighbors safely
            boolean leftCheck = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightCheck = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);

            // If both conditions hold, arr[mid] is a peak
            if (leftCheck && rightCheck) {
                return mid;
            }

            // If left neighbor is greater, move left
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else {
                // Otherwise move right
                left = mid + 1;
            }
        }
        return -1; // should never happen if array has at least one element
    }
}