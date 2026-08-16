import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        
        System.out.println(map.size());

      
        for (int count : map.values()) {
            System.out.print(count + " ");
        }
    }
}
