import java.util.*;

class Result {

    public static int powerSum(int X, int N) {
        return countWays(X, N, 1);
    }

    private static int countWays(int target, int power, int base) {
        int value = (int) Math.pow(base, power);

        if (value > target) {
            return 0; 
        } else if (value == target) {
            return 1; 
        } else {
            
            return countWays(target - value, power, base + 1)
                 + countWays(target, power, base + 1);
        }
    }
}

public class ThePowerSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();
        System.out.println(Result.powerSum(X, N));
        sc.close();
    }
}
