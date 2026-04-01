import java.time.LocalDateTime;
import java.util.List;

public class LogTransaction {
    public static void main(String[] args){
        List<Integer> ids = List.of(
            101, 203, 302, 106, 508, 418
        );

        ids.forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction: " + id));
    }
}
