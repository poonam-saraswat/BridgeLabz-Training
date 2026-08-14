import java.util.*;

class Result {


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
}

public class TwoStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();   
        sc.nextLine();         

        for (int i = 0; i < q; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            String result = Result.twoStrings(s1, s2);
            System.out.println(result);
        }

        sc.close();
    }
}
