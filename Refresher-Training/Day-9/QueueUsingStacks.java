import java.util.*;

class MyQueue<T> {
    Stack<T> stackNewestOnTop = new Stack<>();
    Stack<T> stackOldestOnTop = new Stack<>();
    public void enqueue(T value) {
        stackNewestOnTop.push(value);
    }

    // Shift elements from newest stack to oldest stack if needed
    private void shiftStacks() {
        if (stackOldestOnTop.isEmpty()) {
            while (!stackNewestOnTop.isEmpty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }
    
    public T dequeue() {
        shiftStacks();
        return stackOldestOnTop.pop();
    }
    public T peek() {
        shiftStacks();
        return stackOldestOnTop.peek();
    }
}

public class QueueUsingStacks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // number of queries
        MyQueue<Integer> queue = new MyQueue<>();

        for (int i = 0; i < n; i++) {
            int type = scan.nextInt();
            if (type == 1) {
                int value = scan.nextInt();
                queue.enqueue(value);
            } else if (type == 2) {
                queue.dequeue();
            } else if (type == 3) {
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
