import java.io.*;
import java.util.*;

class Result {

    public static String balancedSums(List<Integer> arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            int rightSum = totalSum - leftSum - arr.get(i);

            if (leftSum == rightSum) {
                return "YES";
            }

            leftSum += arr.get(i);
        }

        return "NO";
    }
}

public class SherlockAndArray {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // number of test cases
        while (T-- > 0) {
            int n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            System.out.println(Result.balancedSums(arr));
        }
    }
}
