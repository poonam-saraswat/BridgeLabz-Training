import java.util.*;

public class RemoveDuplicates{
    public static void removeDuplicates(List<Integer> list){
        for(int i = 0; i < list.size()-1; i++){
            for(int j = i+1; j < list.size(); j++){
                if(list.get(i).equals(list.get(j))){
                    list.remove(j);
                    j--;
                }
            }
        }

        System.out.println(list);
    }

    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter list size: ");
            int n = sc.nextInt();

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < n; i++){
                list.add(sc.nextInt());
            }
            
            removeDuplicates(list);
        }
    }
}