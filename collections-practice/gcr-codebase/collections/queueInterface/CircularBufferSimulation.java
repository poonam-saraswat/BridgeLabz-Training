import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int size;
    private int head; // points to oldest element
    private int tail; // points to next insertion position
    private int count; // number of elements currently in buffer

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        head = 0;
        tail = 0;
        count = 0;
    }

    // Insert element (overwrite oldest if full)
    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % size;

        if (count == size) {
            // Buffer full → move head forward (overwrite oldest)
            head = (head + 1) % size;
        } else {
            count++;
        }
    }

    // Display buffer contents in order
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            int index = (head + i) % size;
            System.out.print(buffer[index]);
            if (i < count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

public class CircularBufferSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input buffer size
        System.out.print("Enter buffer size: ");
        int size = sc.nextInt();
        CircularBuffer cb = new CircularBuffer(size);

        // Input number of insertions
        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            cb.insert(val);
            cb.display();
        }

        sc.close();
    }
}