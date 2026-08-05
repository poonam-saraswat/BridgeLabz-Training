import java.util.*;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Result {

    public static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            return newNode;
        }

        SinglyLinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }
}

public class InsertNodeAtTail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SinglyLinkedListNode head = null;
        int n = scanner.nextInt();  // number of elements

        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            head = Result.insertNodeAtTail(head, data);
        }

        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        scanner.close();
    }
}
