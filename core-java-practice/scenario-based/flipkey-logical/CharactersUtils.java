public class CharactersUtils{
    public static String isValid(String word){
        if(word == null || word.length() < 6){
            return "";
        }
        else if(word.matches(".*[^a-zA-Z].*")){
            return "";
        }

        return word;
    }

    public static boolean hasEvenASCII(char c){
        int ascii = (int) c;
        if(ascii % 2 == 0){
            return true;
        }

        return false;
    }
}