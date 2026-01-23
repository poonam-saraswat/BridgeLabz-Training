import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Set1
        System.out.print("Enter number of elements in Set1: ");
        int n1 = sc.nextInt();
        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements of Set1:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        // Input for Set2
        System.out.print("Enter number of elements in Set2: ");
        int n2 = sc.nextInt();
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements of Set2:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }

        // Symmetric Difference
        Set<Integer> symDiff = new HashSet<>(set1);
        symDiff.addAll(set2); // union
        Set<Integer> tmp = new HashSet<>(set1);
        tmp.retainAll(set2); // intersection
        symDiff.removeAll(tmp); // remove intersection from union

        // Output
        System.out.println("Symmetric Difference: " + symDiff);

        sc.close();
    }
}