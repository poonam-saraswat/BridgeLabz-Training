import java.io.*;
import java.util.*;

public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();   

        StringBuilder compressed = new StringBuilder();

        int count = 1;  
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(s.charAt(i - 1));
                if (count > 1) {
                    compressed.append(count);
                }
                count = 1; 
            }
        }

        System.out.println(compressed.toString());
    }
}
