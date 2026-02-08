import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order{
    private String name;
    private double totalAmount;

    public Order(String name, double totalAmount){
        this.name = name;
        this.totalAmount = totalAmount;
    }

    public String getName(){ return name; }
    public double getTotalAmount(){ return totalAmount; }
}

public class OrderRevenue {
    public static void main(String[] args){
        List<Order> orders = List.of(
            new Order("Alice", 1200.50),
            new Order("Bob", 800.00),
            new Order("Alice", 950.75),
            new Order("Charlie", 1500.00),
            new Order("Bob", 400.25)
        );

        Map<String, Double> map = orders.stream()
            .collect(
                Collectors.groupingBy(
                    Order::getName,
                    Collectors.summingDouble(Order::getTotalAmount)
                )
            );

        map.forEach((name, amount) -> 
            System.out.println(name + " - " + amount)
        );
    }
}
