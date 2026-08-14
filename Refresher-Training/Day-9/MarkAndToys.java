import java.util.*;

class Result {

    
    public static int maximumToys(List<Integer> prices, int k) {
       
        Collections.sort(prices);

        int count = 0;
        int sum = 0;

       
        for (int price : prices) {
            if (sum + price <= k) {
                sum += price;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

public class MarkAndToys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt(); 
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prices.add(sc.nextInt());
        }

        int result = Result.maximumToys(prices, k);
        System.out.println(result);

        sc.close();
    }
}
