import java.util.Scanner;

public class RotationPointBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Step 2: Input array elements
        System.out.println("Enter " + n + " elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Step 3: Find rotation point using binary search
        int rotationIndex = findRotationPoint(arr);

        // Step 4: Output result
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + arr[rotationIndex]);

        scanner.close();
    }

    // Method to find rotation point
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            // If mid element is greater than right, smallest is in right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Smallest is in left half (including mid)
                right = mid;
            }
        }
        // At the end, left == right, pointing to smallest element
        return left;
    }
}