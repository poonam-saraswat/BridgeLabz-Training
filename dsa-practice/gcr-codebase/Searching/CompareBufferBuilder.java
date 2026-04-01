import java.util.Scanner;

public class CompareBufferBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take user input
        System.out.print("Enter the string to concatenate: ");
        String str = scanner.nextLine();

        System.out.print("Enter the number of times to concatenate: ");
        int n = scanner.nextInt();

        // Step 2: Compare StringBuffer
        StringBuffer sbf = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sbf.append(str);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        // Step 3: Compare StringBuilder
        StringBuilder sbd = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sbd.append(str);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        // Step 4: Output results
        System.out.println("\nPerformance Comparison:");
        System.out.println("StringBuffer time: " + timeBuffer + " nanoseconds");
        System.out.println("StringBuilder time: " + timeBuilder + " nanoseconds");

        // Step 5: Close scanner
        scanner.close();
    }
}