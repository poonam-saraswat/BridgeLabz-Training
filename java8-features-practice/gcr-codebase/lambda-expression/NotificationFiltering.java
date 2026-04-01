import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;

    Alert(String type) {
        this.type = type;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {

        List<Alert> alerts = List.of(
                new Alert("CRITICAL"),
                new Alert("NORMAL"),
                new Alert("INFO")
        );

        Predicate<Alert> criticalOnly = alert -> alert.type.equals("CRITICAL");

        alerts.stream().filter(criticalOnly).forEach(a -> System.out.println(a.type));
    }
}
