import java.util.*;

public class MigratoryBirds {

   
    public static int migratoryBirds(List<Integer> arr) {
        int[] count = new int[6]; 

      
        for (int bird : arr) {
            count[bird]++;
        }

        int maxCount = 0;
        int result = 0;
        for (int i = 1; i <= 5; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int result = migratoryBirds(arr);
        System.out.println(result);
    }
}
