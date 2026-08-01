import java.util.*;

public class CamelCase {

    static int camelcase(String s) {
        int count = 1; 
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int result = camelcase(s);
        System.out.println(result);

        sc.close();
    }
}
