public class WordValidate {
    public static boolean isValid(String word){
        String[] arr = word.split(" ");
        if(arr.length > 1) return false;

        return true;
    }
}