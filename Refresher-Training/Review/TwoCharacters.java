import java.util.*;

public class TwoCharacters {

    public static int alternate(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        List<Character> chars = new ArrayList<>(uniqueChars);
        int maxLen = 0;

        for (int i = 0; i < chars.size(); i++) {
            for (int j = i + 1; j < chars.size(); j++) {
                char c1 = chars.get(i);
                char c2 = chars.get(j);

                StringBuilder filtered = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c == c1 || c == c2) {
                        filtered.append(c);
                    }
                }

                if (isValid(filtered.toString())) {
                    maxLen = Math.max(maxLen, filtered.length());
                }
            }
        }

        return maxLen;
    }

    private static boolean isValid(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String s = sc.next();
        System.out.println(Result.alternate(s));
    }
}
