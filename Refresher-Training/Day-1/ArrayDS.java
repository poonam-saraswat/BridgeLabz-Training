import java.util.*;

public class ArrayDS {
     public static List<Integer> reverseArray(List<Integer> a) {

        List<Integer> reverse = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            reverse.add(a.get(i));
        }
        return reverse;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        List<Integer> res = reverseArray(arr);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+"");
        }
        sc.close();
    }
}