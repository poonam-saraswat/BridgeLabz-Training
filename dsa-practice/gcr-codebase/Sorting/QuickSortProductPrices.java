import java.util.Scanner;

public class QuickSortProductPrices {

    // Partition method
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing last element as pivot
        int i = low - 1;       // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return partition index
    }

    // Quick Sort method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of products
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        // Take product prices as input
        System.out.println("Enter " + n + " product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println("\nUnsorted Product Prices:");
        printArray(prices);

        // Apply Quick Sort
        quickSort(prices, 0, n - 1);

        System.out.println("Sorted Product Prices (Ascending):");
        printArray(prices);

        sc.close();
    }
}