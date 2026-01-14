import java.util.*;

public class ZeroSumSubarrays {

    // Function to find all subarrays with zero sum
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum is zero, subarray from 0 to i
            if (sum == 0) {
                result.add(new int[]{0, i});
            }

            // If sum already exists in map, subarray(s) found
            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            // Store current index for this sum
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    // Demo
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Zero-sum subarrays (startIndex, endIndex):");
        for (int[] sub : subarrays) {
            System.out.println(Arrays.toString(sub));
        }
    }
}