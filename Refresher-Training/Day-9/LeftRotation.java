import java.util.*;

public class LeftRotation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        List<Integer> result = rotateLeft(a, d);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)+" ");
        }

        sc.close();
    }

    public static List<Integer> rotateLeft(List<Integer> a, int d) {
        int n = a.size();
        List<Integer> leftRotated = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            leftRotated.add(a.get((i + d) % n));
        }
        return leftRotated;
    }
}