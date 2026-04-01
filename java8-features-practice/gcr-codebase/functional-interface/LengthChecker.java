import java.util.function.*;

public class LengthChecker {
    public static void main(String[] args){
        String s = "This is a secret message";
        int length = 20;

        Function<String, Integer> len = str -> str.length();
        int givenLen = len.apply(s);

        if(length > givenLen){
            System.out.println("String exceeds limit!");
        }
        else{
            System.out.println("String is within limit!");
        }
    }
}
