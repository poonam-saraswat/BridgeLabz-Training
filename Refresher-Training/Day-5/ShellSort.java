import java.util.*;

class ShellSort {

 
    public static int[] shellSortOriginal(int[] arr) {
        int n = arr.length;
        int comparisons = 0, shifts = 0;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    comparisons++;
                    arr[j] = arr[j - gap];
                    j -= gap;
                    shifts++;
                }
                if (j >= gap) comparisons++; 
                arr[j] = temp;
            }
        }
        System.out.println("Shell's sequence → Comparisons: " + comparisons + ", Shifts: " + shifts);
        return arr;
    }

    // Shell Sort using Knuth's sequence (h = 3h+1)
    public static int[] shellSortKnuth(int[] arr) {
        int n = arr.length;
        int comparisons = 0, shifts = 0;

        // Generate largest Knuth gap
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= h && arr[j - h] > temp) {
                    comparisons++;
                    arr[j] = arr[j - h];
                    j -= h;
                    shifts++;
                }
                if (j >= h) comparisons++;
                arr[j] = temp;
            }
            h = h / 3;
        }
        System.out.println("Knuth's sequence → Comparisons: " + comparisons + ", Shifts: " + shifts);
        return arr;
    }

    public static void main(String[] args) {
        int[] input = {9, 8, 3, 7, 5, 6, 4, 1};

      
        int[] arr1 = Arrays.copyOf(input, input.length);
        System.out.println("Original array: " + Arrays.toString(input));
        shellSortOriginal(arr1);
        System.out.println("Sorted (Shell's): " + Arrays.toString(arr1));

  
        int[] arr2 = Arrays.copyOf(input, input.length);
        shellSortKnuth(arr2);
        System.out.println("Sorted (Knuth's): " + Arrays.toString(arr2));
    }
}
