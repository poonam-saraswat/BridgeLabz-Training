import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        WordProcessor wp = new WordProcessor();

        System.out.println("Enter the word: ");
        String word = sc.nextLine();

        String ans = "";

        if(CharactersUtils.isValid(word).equals("")){
            System.out.println("Invalid Input!");
        }
        else{
            ans = wp.CleanseAndInvert(word);
        }

        System.out.println(ans);
    }
}