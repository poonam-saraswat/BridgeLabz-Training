import java.util.Objects;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class CustomHashMap<K, V> {
    private int capacity;
    private Node<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node[capacity];
    }

    private int hash(K key) {
        return Math.abs(Objects.hashCode(key)) % capacity;
    }

    // Insert or update
    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> head = buckets[index];

        Node<K, V> current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value; // update existing
                return;
            }
            current = current.next;
        }

        // Insert new node at head
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    // Retrieve
    public V get(K key) {
        int index = hash(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // not found
    }

    // Remove
    public boolean remove(K key) {
        int index = hash(key);
        Node<K, V> current = buckets[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    buckets[index] = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false; // not found
    }

    // Print map contents
    public void printMap() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> current = buckets[i];
            while (current != null) {
                System.out.print(current.key + ": " + current.value + " | ");
                current = current.next;
            }
        }
        System.out.println();
    }

    // Demo
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(10);

        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        map.printMap(); // apple: 10 | banana: 20 | orange: 30 |

        System.out.println("Get banana: " + map.get("banana")); // 20
        System.out.println("Get grape: " + map.get("grape"));   // null

        map.put("banana", 25); // update
        System.out.println("Updated banana: " + map.get("banana")); // 25

        map.remove("apple");
        map.printMap(); // banana: 25 | orange: 30 |
    }
}
