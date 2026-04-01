// Node class representing each text state
class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

// Doubly Linked List Text Editor
class TextEditor {
    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10; // limit history size

    // Add new text state at the end
    public void addState(String content) {
        TextState newState = new TextState(content);

        // If current is not at the tail, discard redo history
        if (current != tail && current != null) {
            current.next = null;
            tail = current;
            size = countStates();
        }

        if (head == null) {
            head = tail = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        }
        current = tail;
        size++;

        // Enforce max history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo functionality
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed. Current state: " + current.content);
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo functionality
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed. Current state: " + current.content);
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display current state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }

    // Count states (helper for enforcing history size)
    private int countStates() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Display all states (for debugging)
    public void displayAllStates() {
        TextState temp = head;
        System.out.println("All States in History:");
        while (temp != null) {
            System.out.println(temp.content + (temp == current ? " <-- Current" : ""));
            temp = temp.next;
        }
    }
}

// Driver class
public class TextEditorSystem {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! This is a test.");

        editor.displayCurrentState();

        System.out.println("\nPerforming Undo:");
        editor.undo();
        editor.displayCurrentState();

        System.out.println("\nPerforming Undo:");
        editor.undo();
        editor.displayCurrentState();

        System.out.println("\nPerforming Redo:");
        editor.redo();
        editor.displayCurrentState();

        System.out.println("\nAdding new state after undo (redo history cleared):");
        editor.addState("Hello World! Final State");
        editor.displayAllStates();

        System.out.println("\nPerforming multiple undos:");
        editor.undo();
        editor.undo();
        editor.displayCurrentState();

        System.out.println("\nPerforming multiple redos:");
        editor.redo();
        editor.redo();
        editor.displayCurrentState();
    }
}
