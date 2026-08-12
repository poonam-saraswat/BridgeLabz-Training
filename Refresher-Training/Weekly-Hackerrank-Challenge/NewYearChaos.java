import java.util.*;

class Result {

    public static void minimumBribes(List<Integer> q) {
        int bribes = 0;

        for (int i = 0; i < q.size(); i++) {
  
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }
}

public class NewYearChaos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt(); // size of queue
            List<Integer> q = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                q.add(sc.nextInt());
            }
            Result.minimumBribes(q);
        }
    }
}
