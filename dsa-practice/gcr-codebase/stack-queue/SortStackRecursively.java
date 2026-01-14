import java.util.Stack;

public class SortStackRecursively {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Step 1: Pop the top element
            int top = stack.pop();

            // Step 2: Sort the remaining stack recursively
            sortStack(stack);

            // Step 3: Insert the popped element back in sorted order
            sortedInsert(stack, top);
        }
    }

    // Helper function to insert element in sorted order
    private static void sortedInsert(Stack<Integer> stack, int element) {
        // Base case: stack empty OR top element <= element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            // Pop the top and recurse
            int top = stack.pop();
            sortedInsert(stack, element);
            stack.push(top);
        }
    }

    // Demo
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}