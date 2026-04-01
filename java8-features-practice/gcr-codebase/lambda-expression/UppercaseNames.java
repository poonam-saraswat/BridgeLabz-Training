import java.util.*;

public class UppercaseNames {
    public static void main(String[] args) {

        List<String> names = List.of("alice", "bob", "charlie");

        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
