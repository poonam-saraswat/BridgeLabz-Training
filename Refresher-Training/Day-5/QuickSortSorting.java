import java.util.*;

public class QuickSortSorting {


    public static void quickSort(List<Integer> arr) {
        if (arr.size() <= 1) return;

        int pivot = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : arr) {
            if (num < pivot) {
                left.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                right.add(num);
            }
        }


        quickSort(left);
        quickSort(right);

       
        arr.clear();
        arr.addAll(left);
        arr.addAll(equal);
        arr.addAll(right);

        printArray(arr);
    }

    private static void printArray(List<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        quickSort(arr);
    }
}
