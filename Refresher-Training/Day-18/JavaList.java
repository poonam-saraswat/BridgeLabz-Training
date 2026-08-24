import java.util.*;

public class JavaList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // initial size of list
        List<Integer> list = new LinkedList<>();

        // Read initial list
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int q = sc.nextInt(); 

       
        for (int i = 0; i < q; i++) {
            String command = sc.next();
            if (command.equals("Insert")) {
                int index = sc.nextInt();
                int value = sc.nextInt();
                list.add(index, value);
            } else if (command.equals("Delete")) {
                int index = sc.nextInt();
                list.remove(index);
            }
        }

        
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
