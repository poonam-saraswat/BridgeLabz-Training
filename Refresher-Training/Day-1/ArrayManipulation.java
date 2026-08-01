import java.util.*;

public class ArrayManipulation {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n + 1];
        for (int i = 0; i < queries.size(); i++) {
            int a = queries.get(i).get(0) - 1;
            int b = queries.get(i).get(1) - 1;
            int k = queries.get(i).get(2);

    
            arr[a] += k;
            arr[b + 1] -= k;
        }
        long max = 0;
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if (currentSum > max) max = currentSum;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> queries = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> query = new ArrayList<>();
            query.add(sc.nextInt());
            query.add(sc.nextInt());
            query.add(sc.nextInt());
            queries.add(query);
        }
        long result = arrayManipulation(n, queries);
        System.out.println(result);
        sc.close();
    }
}