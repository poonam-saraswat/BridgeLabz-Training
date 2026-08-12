import java.util.*;

class Result {

    public static void stringPermutations(String[] s) {
        Arrays.sort(s); 
        boolean[] used = new boolean[s.length];
        List<String> current = new ArrayList<>();
        backtrack(s, used, current);
    }

    private static void backtrack(String[] s, boolean[] used, List<String> current) {
        if (current.size() == s.length) {
           
            for (int i = 0; i < current.size(); i++) {
                System.out.print(current.get(i));
                if (i < current.size() - 1) System.out.print(" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            current.add(s[i]);

            backtrack(s, used, current); // recursive branch

            // undo (backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}

public class PermutationOfStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        Result.stringPermutations(s);
        sc.close();
    }
}
