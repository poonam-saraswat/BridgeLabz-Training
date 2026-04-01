import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements in the list: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> list = new ArrayList<>();
        System.out.println("Enter elements (strings):");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        // Frequency map
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        // Output
        System.out.println("Frequency of elements: " + frequencyMap);

        sc.close();
    }
}