import java.util.*;

public class RotateElements{
    public static void rotate(List<Integer> list, int k){
        int n = list.size();

        for(int i = 0; i < k; i++){
            int num = list.get(0);
            list.remove(0);
            list.add(num);
        }

        System.out.println(list);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k: ");
        int k = sc.nextInt();
        System.out.println("Enter list size: ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        
        rotate(list, k);
    }
}