import java.util.*;

public class ReverseList {
    // Method to reverse an ArrayList manually
    public static List<Integer> reverseArrayList(List<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            // Swap elements
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
        return list;
    }

    // Method to reverse a LinkedList manually
    public static List<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversed = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Input elements
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            arrayList.add(val);
            linkedList.add(val);
        }

        // Reverse ArrayList
        List<Integer> reversedArrayList = reverseArrayList(new ArrayList<>(arrayList));
        System.out.println("Reversed ArrayList: " + reversedArrayList);

        // Reverse LinkedList
        List<Integer> reversedLinkedList = reverseLinkedList(new LinkedList<>(linkedList));
        System.out.println("Reversed LinkedList: " + reversedLinkedList);

        sc.close();
    }
}