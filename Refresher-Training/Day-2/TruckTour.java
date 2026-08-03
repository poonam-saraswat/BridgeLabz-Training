import java.util.*;

public class TruckTour {

    public static int truckTour(int[][] petrolpumps) {
        int n = petrolpumps.length;
        Queue<Integer> queue = new LinkedList<>();

        int start = 0;   // candidate starting pump
        int tank = 0;    // current petrol in truck
        int total = 0;   // overall petrol balance

        for (int i = 0; i < n; i++) {
            int petrol = petrolpumps[i][0];
            int distance = petrolpumps[i][1];

            tank += petrol - distance;
            total += petrol - distance;

            queue.add(i);


            if (tank < 0) {
                start = i + 1;
                tank = 0;
                queue.clear();
            }
        }

        return total >= 0 ? start : -1;
    }

    // Simple main method for input/output
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] petrolpumps = new int[n][2];

        for (int i = 0; i < n; i++) {
            petrolpumps[i][0] = sc.nextInt(); // petrol
            petrolpumps[i][1] = sc.nextInt(); // distance
        }

        int result = truckTour(petrolpumps);
        System.out.println(result);

        sc.close();
    }
}
