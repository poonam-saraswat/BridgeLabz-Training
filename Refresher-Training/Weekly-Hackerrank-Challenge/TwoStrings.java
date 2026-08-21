import java.util.*;

public class TwoStrings {

    public static String twoStrings(String s1, String s2) {
       
        Set<Character> set = new HashSet<>();

        for (char c : s1.toCharArray()) {
            set.add(c);
        }

        
        for (char c : s2.toCharArray()) {
            if (set.contains(c)) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        for (int t = 0; t < q; t++) {
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(twoStrings(s1, s2));
        }
    }
}
