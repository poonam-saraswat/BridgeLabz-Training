import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Original map
        Map<String, Integer> originalMap = new HashMap<>();

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

            originalMap.put(key, value);
        }

        // Invert the map
        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            // Add key to the list corresponding to this value
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        // Print original map
        System.out.println("Original Map: " + originalMap);

        // Print inverted map
        System.out.println("Inverted Map: " + invertedMap);

        scanner.close();
    }
}