import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Bubble Sort: O(N^2)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // optimization
        }
    }

    // Merge Sort: O(N log N)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort: O(N log N) average
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Utility: Run experiment
    public static void runExperiment(int size) {
        Random rand = new Random();
        int[] dataset = new int[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = rand.nextInt(size * 10);
        }

        // Bubble Sort timing
        int[] arr1 = Arrays.copyOf(dataset, dataset.length);
        long start = System.nanoTime();
        bubbleSort(arr1);
        long end = System.nanoTime();
        double bubbleTime = (end - start) / 1e6;

        // Merge Sort timing
        int[] arr2 = Arrays.copyOf(dataset, dataset.length);
        start = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        end = System.nanoTime();
        double mergeTime = (end - start) / 1e6;

        // Quick Sort timing
        int[] arr3 = Arrays.copyOf(dataset, dataset.length);
        start = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        end = System.nanoTime();
        double quickTime = (end - start) / 1e6;

        System.out.printf("Dataset Size: %,d | Bubble: %.4f ms | Merge: %.4f ms | Quick: %.4f ms%n",
                size, bubbleTime, mergeTime, quickTime);
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000}; // avoid 1,000,000 for Bubble Sort (too slow!)
        for (int size : sizes) {
            runExperiment(size);
        }
    }
}