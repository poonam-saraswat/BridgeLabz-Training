import java.util.Scanner;

public class HeapSortJobApplicants {

    // Method to heapify a subtree rooted at index i
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;       // Initialize largest as root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Main Heap Sort function
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int salary : arr) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of applicants
        System.out.print("Enter number of applicants: ");
        int n = sc.nextInt();

        int[] salaries = new int[n];

        // Take salary demands as input
        System.out.println("Enter " + n + " salary demands:");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextInt();
        }

        System.out.println("\nUnsorted Salary Demands:");
        printArray(salaries);

        // Apply Heap Sort
        heapSort(salaries);

        System.out.println("Sorted Salary Demands (Ascending):");
        printArray(salaries);

        sc.close();
    }
}