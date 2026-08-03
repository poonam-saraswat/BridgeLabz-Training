import java.util.*;

public class EqualStack {
    public static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int x : h1) sum1 += x;
        for (int x : h2) sum2 += x;
        for (int x : h3) sum3 += x;

        int i1 = 0, i2 = 0, i3 = 0;

        while (!(sum1 == sum2 && sum2 == sum3)) {
            int max = Math.max(sum1, Math.max(sum2, sum3));

            if (sum1 == max && i1 < h1.length) {
                sum1 -= h1[i1++];
            } else if (sum2 == max && i2 < h2.length) {
                sum2 -= h2[i2++];
            } else if (sum3 == max && i3 < h3.length) {
                sum3 -= h3[i3++];
            }
        }

        return sum1; // all sums equal here
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        for (int i = 0; i < n1; i++) h1[i] = sc.nextInt();
        for (int i = 0; i < n2; i++) h2[i] = sc.nextInt();
        for (int i = 0; i < n3; i++) h3[i] = sc.nextInt();

        int result = equalStacks(h1, h2, h3);
        System.out.println(result);

        sc.close();
    }
}
