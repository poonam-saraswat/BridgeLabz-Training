import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Linear Search: O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search: O(log N) (requires sorted array)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Utility: Run experiment
    public static void runExperiment(int size, int target) {
        Random rand = new Random();
        int[] dataset = new int[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = rand.nextInt(size * 10); // random values
        }

        // Linear Search timing
        long start = System.nanoTime();
        linearSearch(dataset, target);
        long end = System.nanoTime();
        double linearTime = (end - start) / 1e6; // ms

        // Binary Search timing (sort first)
        Arrays.sort(dataset);
        start = System.nanoTime();
        binarySearch(dataset, target);
        end = System.nanoTime();
        double binaryTime = (end - start) / 1e6; // ms

        System.out.printf("Dataset Size: %,d | Linear: %.4f ms | Binary: %.4f ms%n",
                size, linearTime, binaryTime);
    }

    public static void main(String[] args) {
        int target = 42; // arbitrary target

        int[] sizes = {1000, 10000, 1000000};
        for (int size : sizes) {
            runExperiment(size, target);
        }
    }
}