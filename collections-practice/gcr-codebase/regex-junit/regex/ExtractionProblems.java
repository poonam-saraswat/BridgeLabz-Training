import java.util.regex.*;
import java.util.*;

public class ExtractionProblems{
    public static void extractEmail(String text){
        String regex = "[a-zA-Z0-9.+_-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println();
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public static void extractCapitalLetterWord(String text){
        String regex = "\\b[A-Z]\\w*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println();
        while(matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }

        public static void extractDates(String text){
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println();
        while(matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }

    public static void extractWebsiteLinks(String text){
        String regex = "https?://(www\\.)?([a-zA-Z0-9.-]+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println();
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = sc.nextLine();

        extractEmail(text);
        extractCapitalLetterWord(text);
        extractDates(text);
        extractWebsiteLinks(text);
    }    
}