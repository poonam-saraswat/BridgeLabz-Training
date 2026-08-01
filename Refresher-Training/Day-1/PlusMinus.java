import java.util.*;

public class PlusMinus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int positive = 0, negative = 0, zero = 0;

        for (int num : arr) {
            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            } else {
                zero++;
            }
        }

      
        double posRatio = (double) positive / n;
        double negRatio = (double) negative / n;
        double zeroRatio = (double) zero / n;

        
        System.out.printf("%.6f%n", posRatio);
        System.out.printf("%.6f%n", negRatio);
        System.out.printf("%.6f%n", zeroRatio);

        sc.close();
    }
}
