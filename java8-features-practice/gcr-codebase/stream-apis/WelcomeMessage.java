import java.util.List;

public class WelcomeMessage {
    public static void main(String[] args){
        List<String> attendes = List.of(
            "Alice", "Bob", "Harper", "Anna", "Claude"
        );

        attendes.stream()
            .forEach(attendee ->
                System.out.println("Welcome to the program " + attendee + "!")
            );
    }
}
