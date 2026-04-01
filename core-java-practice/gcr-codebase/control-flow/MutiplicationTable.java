import java.util.*;
public class MutiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to find its multiplication table from 6 to 9:");
        int number = sc.nextInt();
        for (int i = 6; i <= 9; i++) {
            int result = number * i;
            System.out.println(number + " * " + i + " = " + result);
        }
    }
    
}