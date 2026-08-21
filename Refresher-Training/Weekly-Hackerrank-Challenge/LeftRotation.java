import java.util.*;

public class LeftRotation {

    public static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        int[] rotated = new int[n];

        d = d % n;

        for (int i = 0; i < n; i++) {
            rotated[i] = a[(i + d) % n];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  
        int d = sc.nextInt();  

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
