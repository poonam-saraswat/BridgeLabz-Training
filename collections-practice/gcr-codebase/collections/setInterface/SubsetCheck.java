import java.util.*;

public class SubsetCheck {
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

        // Check if Set1 is subset of Set2
        if (set2.containsAll(set1)) {
            System.out.println("Output: true (Set1 is a subset of Set2)");
        } else {
            System.out.println("Output: false (Set1 is not a subset of Set2)");
        }

        sc.close();
    }
}