import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of set
        System.out.print("Enter number of elements in the set: ");
        int n = sc.nextInt();

        // Create HashSet
        Set<Integer> set = new HashSet<>();
        System.out.println("Enter elements of the set:");
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt()); // duplicates automatically ignored
        }

        // Convert Set to List
        List<Integer> sortedList = new ArrayList<>(set);

        // Sort the list
        Collections.sort(sortedList);

        // Output
        System.out.println("Original Set: " + set);
        System.out.println("Sorted List: " + sortedList);

        sc.close();
    }
}