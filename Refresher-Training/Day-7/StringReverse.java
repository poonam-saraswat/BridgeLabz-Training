import java.util.*;

public class StringReverse {

    
    public static String reverseString(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

 
    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        if (isPalindrome(A)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
