import java.util.*;

public class PairWithGivenSum {

    // Function to check if a pair exists
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            // Check if complement exists
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                return true;
            }

            // Store current number
            seen.add(num);
        }

        System.out.println("No pair found with sum " + target);
        return false;
    }

    // Demo
    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;

        hasPairWithSum(arr, target);
    }
}