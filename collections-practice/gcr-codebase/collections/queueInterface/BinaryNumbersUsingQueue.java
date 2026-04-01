import java.util.*;

public class BinaryNumbersUsingQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input N
        System.out.print("Enter N (number of binary numbers to generate): ");
        int n = sc.nextInt();

        // Queue to generate binary numbers
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        // Start with "1"
        queue.add("1");

        // Generate first N binary numbers
        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);

            // Append "0" and "1" to current and add back to queue
            queue.add(current + "0");
            queue.add(current + "1");
        }

        // Output
        System.out.println("First " + n + " binary numbers: " + result);

        sc.close();
    }
}