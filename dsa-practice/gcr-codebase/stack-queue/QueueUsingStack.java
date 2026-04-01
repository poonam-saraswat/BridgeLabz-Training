import java.util.Stack;

class QueueUsingStacks<T> {
    private Stack<T> inStack;
    private Stack<T> outStack;

    public QueueUsingStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(T item) {
        inStack.push(item);
    }

    // Dequeue operation
    public T dequeue() {
        if (outStack.isEmpty()) {
            // Transfer elements from inStack to outStack
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return outStack.pop();
    }

    // Peek operation (front element)
    public T peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return outStack.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

// Demo
public class QueueUsingStack {
    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.peek());    // 20
        System.out.println(queue.dequeue()); // 20
        System.out.println(queue.dequeue()); // 30

        System.out.println(queue.isEmpty()); // true
    }
}