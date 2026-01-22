import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SymmetricDifference{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input Set1
        System.out.print("Enter number of elements in Set1: ");
        int n1 = sc.nextInt();
        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements of Set1:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        // Input Set2
        System.out.print("Enter number of elements in Set2: ");
        int n2 = sc.nextInt();
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements of Set2:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }

        // Symmetric Difference = (Set1 ∪ Set2) - (Set1 ∩ Set2)
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<Integer> symmetricDifference = new HashSet<>(union);
        symmetricDifference.removeAll(intersection);

        // Output
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + symmetricDifference);

        sc.close();
    }
}