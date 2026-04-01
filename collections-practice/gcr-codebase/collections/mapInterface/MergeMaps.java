import java.util.*;

public class MergeMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // First map
        Map<String, Integer> map1 = new HashMap<>();
        System.out.print("Enter number of entries in Map1: ");
        int n1 = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < n1; i++) {
            System.out.print("Enter key (String) for Map1: ");
            String key = scanner.nextLine();

            System.out.print("Enter value (Integer) for Map1: ");
            int value = scanner.nextInt();
            scanner.nextLine(); // consume newline

            map1.put(key, value);
        }

        // Second map
        Map<String, Integer> map2 = new HashMap<>();
        System.out.print("Enter number of entries in Map2: ");
        int n2 = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < n2; i++) {
            System.out.print("Enter key (String) for Map2: ");
            String key = scanner.nextLine();

            System.out.print("Enter value (Integer) for Map2: ");
            int value = scanner.nextInt();
            scanner.nextLine(); // consume newline

            map2.put(key, value);
        }

        // Merge maps: sum values if key exists in both
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        // Print results
        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);
        System.out.println("Merged Map: " + mergedMap);

        scanner.close();
    }
}