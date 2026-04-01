import java.util.*;

public class IOTReadings {
    public static void main(String[] args){
        List<Double> readings = List.of(
            22.5, 30.2, 18.9, 45.6, 32.3, 27.4, 50.1, 42.9
        );

        double threshold = 30.0;

        readings.stream()
            .filter(reading -> reading > threshold)
            .forEach(reading -> System.out.println("Over threshold: " + reading));
    }
}
