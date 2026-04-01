public class CharacterUtils {
    public static boolean isVowel(char c){
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }

        return false;
    }

    public static boolean isConsonent(char c){
        if(!isVowel(c)){
            return true;
        }

        return false;
    }
}