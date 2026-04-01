import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements in the list: ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Input rotation count
        System.out.print("Enter number of positions to rotate: ");
        int k = sc.nextInt();

        // Normalize k (in case it's larger than list size)
        k = k % n;

        // Rotate manually
        List<Integer> rotated = new ArrayList<>();
        for (int i = k; i < n; i++) {
            rotated.add(list.get(i));
        }
        for (int i = 0; i < k; i++) {
            rotated.add(list.get(i));
        }

        // Output
        System.out.println("Rotated List: " + rotated);

        sc.close();
    }
}