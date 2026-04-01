public class WordProcessor{
    public String CleanseAndInvert(String input){
        String word = input.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for(char c : word.toCharArray()){
            if(!CharactersUtils.hasEvenASCII(c)){
                sb.append(c);
            }
        }

        String ans = sb.reverse().toString();
        sb.setLength(0);

        for(int i = 0; i < ans.length(); i++){
            if(i%2 == 0){
                sb.append(Character.toUpperCase(ans.charAt(i)));
            }
            else{
                sb.append(ans.charAt(i));
            }
        }

        return sb.toString();
    }
}