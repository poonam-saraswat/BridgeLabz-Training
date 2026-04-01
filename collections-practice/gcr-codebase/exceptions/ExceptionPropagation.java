public class ExceptionPropagation{

    // method1: Throws ArithmeticException (10 / 0)
    public static void method1() {
        int result = 10 / 0; // This will throw ArithmeticException
        System.out.println("Result: " + result); // Not executed
    }

    // method2: Calls method1()
    public static void method2() {
        method1(); // Exception propagates here
    }

    // main: Calls method2() and handles the exception
    public static void main(String[] args) {
        try {
            method2(); // Exception propagates further
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}