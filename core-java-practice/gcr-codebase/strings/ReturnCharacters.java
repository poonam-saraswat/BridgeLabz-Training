/*Write a program to return all the characters in a string using the user-defined method,  compare the result with the String built-in toCharArray() method, and display the result
Hint => 
Take user input using the  Scanner next() method to take the text into a String variable
Write a method to return the characters in a string without using the toCharArray() 
Write a method to compare two string arrays and return a boolean result
In the main() call the user-defined method and the String built-in ​​toCharArray() method, compare the 2 arrays, and finally display the result
 */
import java.util.Scanner;
public class ReturnCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Get characters using user-defined method
        char[] userDefinedChars = getCharacters(inputString);

        // Get characters using built-in toCharArray() method
        char[] builtInChars = inputString.toCharArray();

        boolean areEqual = compareCharArrays(userDefinedChars, builtInChars);

        System.out.println("Characters from user-defined method: " + String.valueOf(userDefinedChars));
        System.out.println("Characters from built-in toCharArray() method: " + String.valueOf(builtInChars));
        System.out.println("Are both character arrays equal? " + areEqual);

        scanner.close();
    }

    public static char[] getCharacters(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    // Method to compare two character arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}