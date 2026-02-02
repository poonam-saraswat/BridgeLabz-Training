import java.util.Scanner;

public class LexicalTwist{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word: ");
        String w1 = sc.nextLine();

        if(!WordValidate.isValid(w1)){
            System.out.println(w1 + " is an invalid word.");
            return;
        }

        System.out.println("Enter the second word: ");
        String w2 = sc.nextLine();

        if(!WordValidate.isValid(w2)){
            System.out.println(w2 + " is an invalid word.");
            return;
        }

        String ans;

        if(WordProcessor.isReversed(w1, w2)){
            ans = WordProcessor.ifReverseTransform(w1);
            System.out.println(ans);
        }
        else{
            WordProcessor.combineWords(w1, w2);
        }
    }
}