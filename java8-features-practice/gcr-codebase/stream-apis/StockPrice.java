import java.util.List;

public class StockPrice {
    public static void main(String[] args){
        List<Double> stockprices = List.of(
            1450.50, 1462.75, 1458.30, 1470.90, 1465.20 
        );

        stockprices.stream()
            .forEach(price -> System.out.println("Stock price: " + price));
    }
}
