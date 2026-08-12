import java.util.*;

public class IceCreamParlor {

    public static int[] icecreamParlor(int m, int[] cost) {
        Map<Integer, Integer> map = new HashMap<>()

        for (int i = 0; i < cost.length; i++) {
            int complement = m - cost[i];
            if (map.containsKey(complement)) {
                // Found the pair
                return new int[]{map.get(complement) + 1, i + 1}; 
            }
            map.put(cost[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int m = sc.nextInt(); 
            int n = sc.nextInt(); 
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = sc.nextInt();
            }

            int[] result = icecreamParlor(m, cost);
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
