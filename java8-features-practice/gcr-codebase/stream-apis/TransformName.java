import java.util.*;

public class TransformName {
    public static void main(String[] args){
        List<String> names = List.of("Lisha", "Ananya", "Chitranshi", "Muskan", "Sneha", "Alankrati", "Shivang", "Utkarsh");

        names.stream()
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
    }
}
