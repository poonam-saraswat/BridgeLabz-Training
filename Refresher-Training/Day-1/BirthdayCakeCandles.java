import java.util.*;

public class BirthdayCakeCandles {

    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = 0;
        for (int candle : candles) {
            if (candle > max)
                max = candle;
        }
        int maxCount = 0;
        for (int candle : candles) {
            if (candle == max)
                maxCount++;
        }
        return maxCount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> candles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            candles.add(sc.nextInt());
        }
        int result = birthdayCakeCandles(candles);
        System.out.println(result);
        sc.close();
    }

}