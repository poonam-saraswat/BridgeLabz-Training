package annotations;

import java.util.ArrayList;

public class Warnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        ArrayList list = new ArrayList();
        list.add("hi");
        list.add(1);

        String ans = (String) list.get(0);
        System.out.println(ans);
    }
}