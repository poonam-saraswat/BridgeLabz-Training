import java.util.*;

public class SuperDigit {

   
    public static int superDigit(String n, int k) {
        // Step 1: compute sum of digits of n
        long sum = 0;
        for (char c : n.toCharArray()) {
            sum += (c - '0');
        }

        sum *= k;
    return superDigitHelper(sum);
    }

 
    private static int superDigitHelper(long num) {
        if (num < 10) return (int) num;

        long next = 0;
        while (num > 0) {
            next += num % 10;
            num /= 10;
        }
        return superDigitHelper(next);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int k = sc.nextInt();

        System.out.println(superDigit(n, k));
    }
}
