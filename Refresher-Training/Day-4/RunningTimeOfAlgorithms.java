import java.util.*;

class RunningTimeOfAlgorithms {

    public static int runningTime(List<Integer> arr) {
        int shifts = 0;
        int n = arr.size();

        for (int i = 1; i < n; i++) {
            int key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
                shifts++; 
            }

            arr.set(j + 1, key);
        }

        return shifts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int result = runningTime(arr);
        System.out.println(result);
    }
}
