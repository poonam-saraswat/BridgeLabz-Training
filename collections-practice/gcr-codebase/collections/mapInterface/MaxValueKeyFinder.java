import java.util.*;

public class MaxValueKeyFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a map
        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter number of entries in the map: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Take user input for map entries
        for (int i = 0; i < n; i++) {
            System.out.print("Enter key (String): ");
            String key = scanner.nextLine();

            System.out.print("Enter value (Integer): ");
            int value = scanner.nextInt();
            scanner.nextLine(); // consume newline

            map.put(key, value);
        }

        // Find the key with the maximum value
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        // Print results
        System.out.println("Original Map: " + map);
        System.out.println("Key with Maximum Value: " + maxKey);

        scanner.close();
    }
}