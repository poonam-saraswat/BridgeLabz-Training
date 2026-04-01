public class StringConcatComparison {

    // Concatenation using String (Immutable, O(N^2))
    public static void concatWithString(int N) {
        String s = "";
        for (int i = 0; i < N; i++) {
            s += "a"; // creates new object each time
        }
    }

    // Concatenation using StringBuilder (Mutable, O(N))
    public static void concatWithStringBuilder(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
    }

    // Concatenation using StringBuffer (Mutable, Thread-safe, O(N))
    public static void concatWithStringBuffer(int N) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
    }

    // Utility: Run experiment
    public static void runExperiment(int N) {
        long start, end;

        // String
        start = System.nanoTime();
        concatWithString(N);
        end = System.nanoTime();
        double stringTime = (end - start) / 1e6; // ms

        // StringBuilder
        start = System.nanoTime();
        concatWithStringBuilder(N);
        end = System.nanoTime();
        double builderTime = (end - start) / 1e6; // ms

        // StringBuffer
        start = System.nanoTime();
        concatWithStringBuffer(N);
        end = System.nanoTime();
        double bufferTime = (end - start) / 1e6; // ms

        System.out.printf("Operations: %,d | String: %.2f ms | StringBuilder: %.2f ms | StringBuffer: %.2f ms%n",
                N, stringTime, builderTime, bufferTime);
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int N : sizes) {
            runExperiment(N);
        }
    }
}