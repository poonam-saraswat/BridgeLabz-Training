import java.util.*;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args){
        String paragraph = "Java is fun and java is powerful and fun";

        Map<String, Integer> count = Arrays.stream(paragraph.toLowerCase().split("\\s+"))
            .collect(
                Collectors.toMap(word -> word, word -> 1, Integer::sum)
            );

        count.forEach((word, cnt) -> 
            System.out.println(word + " - count: " + cnt)
        );
    }
}
