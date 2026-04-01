import java.util.regex.*;
import java.util.*;

public class ManipulationProblems{
    public static void replaceSpace(String text){
        String replaced = text.replaceAll("\\s+", " ");
        System.out.println(replaced);
        System.out.println();
    }

    public static void replaceBadWords(String text){
        String[] basWords = {"damn", "stupid", "fuck", "shit"};

        String regex = "\\b(" + String.join("|", basWords) + ")\\b";

        String censored = text.replaceAll(regex, "****");
        System.out.println(censored); 
    }

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        replaceSpace(text);
        replaceBadWords(text);
    }
}