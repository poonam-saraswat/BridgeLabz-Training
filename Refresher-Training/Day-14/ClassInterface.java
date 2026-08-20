import java.util.*;

interface AdvancedArithmetic {
    int divisorSum(int n);
}

class MyCalculator implements AdvancedArithmetic {
    @Override
    public int divisorSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

public class ClassInterface {
    public static void main(String[] args) {
        MyCalculator my_calculator = new MyCalculator();
        System.out.println("I implemented: " + my_calculator.getClass().getInterfaces()[0].getSimpleName());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(my_calculator.divisorSum(n));
    }
}
