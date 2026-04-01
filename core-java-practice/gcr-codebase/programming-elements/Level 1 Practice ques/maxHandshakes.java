import java.util.*;
public class maxHandshakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of Students");
        int numberOfStudents = sc.nextInt();
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2; //max handshake calculation formula
        System.out.println("The maximum number of handshakes possible is: " + maxHandshakes);
        sc.close();     
    }
    
}
