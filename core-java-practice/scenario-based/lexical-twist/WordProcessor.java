import java.util.LinkedHashSet;

public class WordProcessor {
    public static boolean isReversed(String word1, String word2){
        StringBuilder reversed = new StringBuilder(word1);
        String rev = reversed.reverse().toString();
        
        if(word2.equalsIgnoreCase(rev)){
            return true;
        }

        return false;
    }

    public static String ifReverseTransform(String w1){
        String rev = new StringBuilder(w1).reverse().toString().toLowerCase();
        StringBuilder sb = new StringBuilder();

        for(char c : rev.toCharArray()){
            if(CharacterUtils.isVowel(c)){
                sb.append('@');
            }
            else{
                sb.append(c);
            }
        }
        
        return sb.toString();
    }

    public static void combineWords(String w1, String w2){
       String word = (w1 + w2).toUpperCase();

       int vowels = vowelCount(word);
       int consonents = consonentCount(word);

        if(vowels > consonents){
            printFirst2Vowels(word);
        }
        else if(consonents > vowels){
            printFirst2Consonents(word);
        }
        else{
            System.out.println("Vowels and consonants are equal.");
        }
    }

    private static int vowelCount(String word){
        int count = 0;
        for(char c : word.toCharArray()){
            if(CharacterUtils.isVowel(c)){
                count++;
            }
        }

        return count;
    }

    private static int consonentCount(String word){
        int count = 0;
        for(char c : word.toCharArray()){
            if(CharacterUtils.isConsonent(c)){
                count++;
            }
        }

        return count;
    }

    private static void printFirst2Vowels(String word){
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for(char c : word.toCharArray()){
            if(CharacterUtils.isVowel(c)){
                set.add(c);
            }
            if(set.size() == 2) break;
        }

        for(char c : set){
            System.out.print(c);
        }
        System.out.println();
    }

    private static void printFirst2Consonents(String word){
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for(char c : word.toCharArray()){
            if(CharacterUtils.isConsonent(c)){
                set.add(c);
            }
            if(set.size() == 2) break;
        }

        for(char c : set){
            System.out.print(c);
        }
        System.out.println();
    }

}