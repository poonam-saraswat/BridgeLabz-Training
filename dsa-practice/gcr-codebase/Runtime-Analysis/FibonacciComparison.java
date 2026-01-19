public class FibonacciComparison {

    // Recursive Fibonacci: O(2^n)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci: O(n)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Utility: Run experiment
    public static void runExperiment(int n) {
        long start, end;

        // Recursive timing
        start = System.nanoTime();
        int recResult = fibonacciRecursive(n);
        end = System.nanoTime();
        double recTime = (end - start) / 1e6; // ms

        // Iterative timing
        start = System.nanoTime();
        int iterResult = fibonacciIterative(n);
        end = System.nanoTime();
        double iterTime = (end - start) / 1e6; // ms

        System.out.printf("N = %d | Recursive: %d (%.4f ms) | Iterative: %d (%.4f ms)%n",
                n, recResult, recTime, iterResult, iterTime);
    }

    public static void main(String[] args) {
        int[] testCases = {10, 30, 50}; // adjust as needed
        for (int n : testCases) {
            runExperiment(n);
        }
    }
}