import java.util.*;

class InsertionSortOne {

    public static void insertionSort1(int n, List<Integer> arr) {
        int target= arr.get(n - 1);
        int index = 0; 

        
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) > target) {
                arr.set(i + 1, arr.get(i)); 
                printArray(arr);
            } else {
                arr.set(i + 1, target); 
                printArray(arr);
                return;
            }
        }

        
        arr.set(index, target);
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
        insertionSort1(n, arr);
    }
}
