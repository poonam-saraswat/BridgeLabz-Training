import java.util.*;

public class ReverseQueue {
    // Method to reverse a queue using recursion
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        // Remove front element
        int front = queue.remove();
        // Recursively reverse the remaining queue
        reverseQueue(queue);
        // Add the removed element back at the end
        queue.add(front);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements in the queue: ");
        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);

        sc.close();
    }
}