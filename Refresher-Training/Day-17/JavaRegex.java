import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

class MyRegex {
    // Regex pattern for valid IPv4 address
    String pattern = 
        "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}"
      + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
}

public class JavaRegex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyRegex mr = new MyRegex();
        Pattern p = Pattern.compile(mr.pattern);

        // Read multiple test cases from input
        while (sc.hasNext()) {
            String ip = sc.next();
            Matcher m = p.matcher(ip);
            System.out.println(m.matches());
        }
        sc.close();
    }
}
