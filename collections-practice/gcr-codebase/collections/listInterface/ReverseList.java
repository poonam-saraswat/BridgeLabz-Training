import java.util.*;

public class ReverseList{
    public static void reverse(List<Integer> list){
        int n = list.size();
        List<Integer> l = new ArrayList<>();


        for(int i = n-1; i >= 0; i--){
           l.add(list.get(i));
        }


        System.out.println(l);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter list size: ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        
        reverse(list);
    }
} 