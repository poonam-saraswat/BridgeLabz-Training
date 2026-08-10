import java.util.*;

public class PowerFunction {

    static int naiveCalls = 0;
    static int fastCalls = 0;

    
    public static long power(long x, int n) {
        naiveCalls++;
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }

  
    public static long fastPower(long x, int n) {
        fastCalls++;
        if (n == 0) return 1;

        long half = fastPower(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
      
        naiveCalls = 0;
        fastCalls = 0;
        long result1 = power(2, 10);
        long result2 = fastPower(2, 10);
        System.out.println("power(2,10) naive = " + result1 + " (calls=" + naiveCalls + ")");
        System.out.println("power(2,10) fast  = " + result2 + " (calls=" + fastCalls + ")");

        naiveCalls = 0;
        fastCalls = 0;
        long result3 = power(3, 13);
        long result4 = fastPower(3, 13);
        System.out.println("power(3,13) naive = " + result3 + " (calls=" + naiveCalls + ")");
        System.out.println("power(3,13) fast  = " + result4 + " (calls=" + fastCalls + ")");
    }
}
