import java.util.*;

public class MissingNumbers {

    public static List<Integer> missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> freq = new HashMap<>();

       
        for (int num : brr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        
        for (int num : arr) {
            freq.put(num, freq.get(num) - 1);
        }

        
        List<Integer> result = new ArrayList<>();
        for (int num : freq.keySet()) {
            if (freq.get(num) > 0) {
                result.add(num);
            }
        }

        // Sort result before returning
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt(); // size of brr
        int[] brr = new int[m];
        for (int i = 0; i < m; i++) {
            brr[i] = sc.nextInt();
        }

        List<Integer> result = missingNumbers(arr, brr);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
