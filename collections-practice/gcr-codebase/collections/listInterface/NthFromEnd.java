import java.util.*;

public class NthFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements in the LinkedList: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        // Input N
        System.out.print("Enter N (position from end): ");
        int k = sc.nextInt();

        // Two-pointer technique
        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

        // Move fast pointer k steps ahead
        int steps = 0;
        while (fast.hasNext() && steps < k) {
            fast.next();
            steps++;
        }

        // If k > size
        if (steps < k) {
            System.out.println("N is larger than the size of the list!");
            sc.close();
            return;
        }

        // Move both until fast reaches end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        // slow now points to Nth from end
        System.out.println("Nth element from the end: " + slow.next());

        sc.close();
    }
}