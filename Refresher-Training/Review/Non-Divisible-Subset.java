import java.util.*;

public class Solution {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
      
        int[] freq = new int[k];

        for (int num : s) {
            freq[num % k]++;
        }

        int count = Math.min(freq[0], 1);

        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
               
                count += Math.max(freq[i], freq[k - i]);
            } else {
               
                count += 1;
            }
        }

       
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt(); 
        int k = sc.nextInt(); 

       
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }

        int result = nonDivisibleSubset(k, s);
        System.out.println(result);

        sc.close();
    }
}
