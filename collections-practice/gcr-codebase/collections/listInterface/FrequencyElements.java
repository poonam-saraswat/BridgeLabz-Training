import java.util.*;

public class FrequencyElements{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String str = sc.nextLine().toLowerCase();
        String[] text = str.split(" ");

        Map<String, Integer> map = new HashMap<>();
    
        for(int i = 0; i < text.length; i++){
            map.put(text[i], map.getOrDefault(text[i], 0) + 1);
        }
        
        System.out.println(map);
    }
}