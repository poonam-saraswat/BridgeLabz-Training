import java.util.*;

public class MinimumSwaps {

    public static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            
            while (arr[i] != i + 1) {
                int correctIndex = arr[i] - 1;

           
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;

                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = minimumSwaps(arr);
        System.out.println(result);
    }
}
