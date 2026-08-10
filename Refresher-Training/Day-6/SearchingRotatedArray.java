import java.util.*;

public class SearchingRotatedArray {

    
    public static int searchRotated(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

           
            System.out.println("low=" + low + ", mid=" + mid + ", high=" + high);

            if (arr[mid] == target) {
                return mid;
            }

            
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
         
            else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Searching for 0:");
        int idx1 = searchRotated(arr, 0);
        System.out.println("Result index: " + idx1);

      
        System.out.println("\nSearching for 3:");
        int idx2 = searchRotated(arr, 3);
        System.out.println("Result index: " + idx2);
    }
}
