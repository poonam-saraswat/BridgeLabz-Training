import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubsetCheck {
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

        // Check if Set1 is a subset of Set2
        boolean isSubset = set2.containsAll(set1);

        // Output
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Is Set1 a subset of Set2? " + isSubset);

        sc.close();
    }
}