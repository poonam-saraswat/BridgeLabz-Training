class Calculator {
    // Overloaded method 1: two integers
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method 2: two doubles
    double add(double a, double b) {
        return a + b;
    }

    // Overloaded method 3: three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int sum1 = calc.add(5, 10);          
        double sum2 = calc.add(3.5, 2.7);   
        int sum3 = calc.add(1, 2, 3);        

      
        System.out.println("Sum of two ints: " + sum1);
        System.out.println("Sum of two doubles: " + sum2);
        System.out.println("Sum of three ints: " + sum3);
    }
}
