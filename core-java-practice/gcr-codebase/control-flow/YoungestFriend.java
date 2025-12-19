import java.util.*;
public class YoungestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Amar's age:");
        int amarAge = sc.nextInt();
        System.out.println("Enter Akbar's age:");
        int akbarAge = sc.nextInt();
        System.out.println("Enter Anthony's age:");
        int anthonyAge = sc.nextInt();
        
        System.out.println("Enter Amar's height (in cm):");
        int amarHeight = sc.nextInt();
        System.out.println("Enter Akbar's height (in cm):");
        int akbarHeight = sc.nextInt();
        System.out.println("Enter Anthony's height (in cm):");
        int anthonyHeight = sc.nextInt();
        
        // Finding the youngest friend
        String youngestFriend;
        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            youngestFriend = "Amar";
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            youngestFriend = "Akbar";
        } else {
            youngestFriend = "Anthony";
        }
        
        // Finding the tallest friend
        String tallestFriend;
        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            tallestFriend = "Amar";
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            tallestFriend = "Akbar";
        } else {
            tallestFriend = "Anthony";
        }
        
        System.out.println("The youngest friend is: " + youngestFriend);
        System.out.println("The tallest friend is: " + tallestFriend);
    }
}
