import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Insurance{
    private String claimType;
    private double amount;

    public Insurance(String claimType, double amount){
        this.claimType = claimType;
        this.amount = amount;
    }

    public String getClaimType(){ return claimType; }
    public double getAmount(){ return amount; }
}

public class InsuranceClaim {
    public static void main(String[] args){
        List<Insurance> claims = List.of(
            new Insurance("Health", 50000.0),
            new Insurance("Vehicle", 20000.0),
            new Insurance("Health", 30000.0),
            new Insurance("Life", 100000.0),
            new Insurance("Vehicle", 40000.0)
        );

        Map<String, Double> averageAmount = claims.stream()
            .collect(
                Collectors.groupingBy(
                    Insurance::getClaimType,
                    Collectors.averagingDouble(Insurance::getAmount)
                )
            );

        averageAmount.forEach((type, avg) -> System.out.println(type + " : " + avg));
    }
}
