import java.util.Scanner;

public class MergeSortBookPrices {

    // Merge two halves
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;   // size of left subarray
        int n2 = right - mid;      // size of right subarray

        // Temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Merge temp arrays back into arr[left..right]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Recursive Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
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

        // Take number of books
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        // Take book prices as input
        System.out.println("Enter " + n + " book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println("\nUnsorted Book Prices:");
        printArray(prices);

        // Apply Merge Sort
        mergeSort(prices, 0, n - 1);

        System.out.println("Sorted Book Prices (Ascending):");
        printArray(prices);

        sc.close();
    }
}