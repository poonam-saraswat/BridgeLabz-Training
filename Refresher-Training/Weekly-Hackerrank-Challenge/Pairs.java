import java.io.*;
import java.util.*;

class Result {

    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr);
        int count = 0;

        for (int num : arr) {
            if (set.contains(num + k)) {
                count++;
            }
        }

        return count;
    }
}

public class Pairs {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int result = Result.pairs(k, arr);
        System.out.println(result);
    }
}
