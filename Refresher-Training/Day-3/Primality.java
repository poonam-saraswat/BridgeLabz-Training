import java.io.*;
import java.util.*;

public class Primality {

    public static void primalityfunc(int n) {
        if (n < 2) {
            System.out.println("Not prime");
            return;
        }
        if (n == 2) {
            System.out.println("Prime");
            return;
        }
        if (n % 2 == 0) {
            System.out.println("Not prime");
            return;
        }

        int sqrt = (int)Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                System.out.println("Not prime");
                return;
            }
        }

        System.out.println("Prime");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        primalityfunc(n);
        scanner.close();
    }
}
