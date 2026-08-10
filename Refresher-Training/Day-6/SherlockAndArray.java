import java.util.*;

public class SherlockAndArray {


    public static String sherlockAndArray(int[] arr) {
        int n = arr.length;

        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
          
            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return "YES";
            }

            leftSum += arr[i];
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // number of test cases
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(sherlockAndArray(arr));
        }
    }
}
