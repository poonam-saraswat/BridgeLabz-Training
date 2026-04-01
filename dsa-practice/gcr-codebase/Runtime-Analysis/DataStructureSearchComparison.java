import java.util.*;

public class DataStructureSearchComparison {

    // Linear search in Array: O(N)
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    // Utility: Run experiment
    public static void runExperiment(int size, int target) {
        Random rand = new Random();

        // Prepare dataset
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size * 10);
        }

        // Array Search timing
        long start = System.nanoTime();
        linearSearch(array, target);
        long end = System.nanoTime();
        double arrayTime = (end - start) / 1e6; // ms

        // HashSet Search timing
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : array) hashSet.add(num);
        start = System.nanoTime();
        hashSet.contains(target);
        end = System.nanoTime();
        double hashSetTime = (end - start) / 1e6; // ms

        // TreeSet Search timing
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : array) treeSet.add(num);
        start = System.nanoTime();
        treeSet.contains(target);
        end = System.nanoTime();
        double treeSetTime = (end - start) / 1e6; // ms

        System.out.printf("Dataset Size: %,d | Array: %.4f ms | HashSet: %.4f ms | TreeSet: %.4f ms%n",
                size, arrayTime, hashSetTime, treeSetTime);
    }

    public static void main(String[] args) {
        int target = 42; // arbitrary target
        int[] sizes = {1000, 100000, 1000000};

        for (int size : sizes) {
            runExperiment(size, target);
        }
    }
}