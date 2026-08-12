import java.io.*;
import java.util.*;

class Result {


    public static int activityNotifications(List<Integer> expenditure, int d) {
        int notifications = 0;
        int[] freq = new int[201]; 

        
        for (int i = 0; i < d; i++) {
            freq[expenditure.get(i)]++;
        }

        for (int i = d; i < expenditure.size(); i++) {
            double median = getMedian(freq, d);

            if (expenditure.get(i) >= 2 * median) {
                notifications++;
            }

            
            freq[expenditure.get(i - d)]--;
            freq[expenditure.get(i)]++;
        }

        return notifications;
    }

    // compute median from frequency array
    private static double getMedian(int[] freq, int d) {
        int count = 0;
        int m1 = -1, m2 = -1;

        if (d % 2 == 1) {
            int mid = d / 2 + 1;
            for (int i = 0; i < freq.length; i++) {
                count += freq[i];
                if (count >= mid) {
                    return i;
                }
            }
        } else {
            int mid1 = d / 2;
            int mid2 = mid1 + 1;
            for (int i = 0; i < freq.length; i++) {
                count += freq[i];
                if (m1 == -1 && count >= mid1) {
                    m1 = i;
                }
                if (count >= mid2) {
                    m2 = i;
                    break;
                }
            }
            return (m1 + m2) / 2.0;
        }
        return 0;
    }
}

public class FraudulentActivityNotification {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        List<Integer> expenditure = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            expenditure.add(sc.nextInt());
        }
        int result = Result.activityNotifications(expenditure, d);
        System.out.println(result);
    }
}
