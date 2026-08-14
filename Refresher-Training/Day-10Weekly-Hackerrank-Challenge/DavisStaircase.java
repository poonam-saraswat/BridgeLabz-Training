import java.util.*;

class Result {

    public static int stepPerms(int n) {
        int MOD = 1000000007; 
        Map<Integer, Integer> memo = new HashMap<>();
        return stepPermsHelper(n, memo, MOD);
    }

    private static int stepPermsHelper(int n, Map<Integer, Integer> memo, int MOD) {
        if (n < 0) return 0;   
        if (n == 0) return 1;  

        if (memo.containsKey(n)) return memo.get(n);

        long ways = (long) stepPermsHelper(n - 1, memo, MOD)
                  + stepPermsHelper(n - 2, memo, MOD)
                  + stepPermsHelper(n - 3, memo, MOD);

        int result = (int) (ways % MOD);
        memo.put(n, result);
        return result;
    }
}

public class DavisStaircase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); 
        while (s-- > 0) {
            int n = sc.nextInt();
            System.out.println(Result.stepPerms(n));
        }
        sc.close();
    }
}
