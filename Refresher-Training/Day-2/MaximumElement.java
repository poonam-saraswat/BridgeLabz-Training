import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int value = sc.nextInt();
                stack.push(value);
                
                if (maxStack.isEmpty() || value >= maxStack.peek()) {
                    maxStack.push(value);
                }
            } else if (type == 2) {
                if (!stack.isEmpty()) {
                    int removed = stack.pop();
                    if (removed == maxStack.peek()) {
                        maxStack.pop();
                    }
                }
            } else if (type == 3) {
                System.out.println(maxStack.peek());
            }
        }
        sc.close();
    }
}
