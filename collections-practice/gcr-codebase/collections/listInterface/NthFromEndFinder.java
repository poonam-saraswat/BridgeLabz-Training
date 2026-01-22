import java.util.LinkedList;
import java.util.Iterator;

public class NthFromEndFinder {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("N is larger than the list size");
            }
            first.next();
        }

        // Move both pointers until first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        // second now points to the Nth element from the end
        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;
        String result = findNthFromEnd(list, n);
        System.out.println("Nth element from the end: " + result); // Output: D
    }
}