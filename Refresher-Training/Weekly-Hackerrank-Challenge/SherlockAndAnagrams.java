import java.util.*;

public class SherlockAndAnagrams {

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            freq[c - 'a']--;
        }
        for (int f : freq) {
            if (f != 0) return false;
        }
        return true;
    }

    public static int sherlockAndAnagrams(String s) {
        int count = 0;
        int n = s.length();

      
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                String sub1 = s.substring(i, i + len);
                for (int j = i + 1; j + len <= n; j++) {
                    String sub2 = s.substring(j, j + len);
                    if (isAnagram(sub1, sub2)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        sc.nextLine();

        for (int t = 0; t < q; t++) {
            String s = sc.nextLine();
            System.out.println(sherlockAndAnagrams(s));
        }
    }
}
