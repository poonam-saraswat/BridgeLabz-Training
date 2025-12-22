import java.util.Scanner;
public class UpperCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Convert to uppercase using user-defined method
        String upperCaseUserDefined = convertToUpperCase(inputString);

        // Convert to uppercase using built-in method
        String upperCaseBuiltIn = inputString.toUpperCase();

        // Compare the two uppercase strings
        boolean areEqual = compareStrings(upperCaseUserDefined, upperCaseBuiltIn);

        System.out.println("Uppercase using user-defined method: " + upperCaseUserDefined);
        System.out.println("Uppercase using built-in toUpperCase() method: " + upperCaseBuiltIn);
        System.out.println("Are both uppercase strings equal? " + areEqual);

        scanner.close();
    }

    public static String convertToUpperCase(String str) {
        StringBuilder upperCaseStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32); // Convert to uppercase
            }
            upperCaseStr.append(ch);
        }
        return upperCaseStr.toString();
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
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