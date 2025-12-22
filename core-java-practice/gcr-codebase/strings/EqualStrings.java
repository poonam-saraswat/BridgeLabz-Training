/*Write a program to compare two strings using the charAt() method and check the result with the built-in String equals() method
Hint => 
Take user input using the  Scanner next() method for 2 String variables
Write a method to compare two strings using the charAt() method and return a boolean result
Use the String Built-In method to check if the results are the same and display the result 
 */
import java.util.Scanner;
public class EqualStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        boolean areEqualUsingCharAt = compareStringsUsingCharAt(str1, str2);
        boolean areEqualUsingEquals = str1.equals(str2);

        System.out.println("Are the strings equal using charAt()? " + areEqualUsingCharAt);
        System.out.println("Are the strings equal using equals()? " + areEqualUsingEquals);

        if (areEqualUsingCharAt == areEqualUsingEquals) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("The methods give different results.");
        }

        scanner.close();
    }

    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}