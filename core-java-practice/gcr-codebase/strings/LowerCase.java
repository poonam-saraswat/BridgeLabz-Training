import java.util.Scanner;
public class LowerCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Convert to lowercase using user-defined method
        String lowerCaseUserDefined = convertToLowerCase(inputString);

        // Convert to lowercase using built-in method
        String lowerCaseBuiltIn = inputString.toLowerCase();

        // Compare the two lowercase strings
        boolean areEqual = compareStrings(lowerCaseUserDefined, lowerCaseBuiltIn);

        System.out.println("Lowercase using user-defined method: " + lowerCaseUserDefined);
        System.out.println("Lowercase using built-in toLowerCase() method: " + lowerCaseBuiltIn);
        System.out.println("Are both lowercase strings equal? " + areEqual);

        scanner.close();
    }

    public static String convertToLowerCase(String str) {
        StringBuilder lowerCaseStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32); // Convert to lowercase
            }
            lowerCaseStr.append(ch);
        }
        return lowerCaseStr.toString();
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