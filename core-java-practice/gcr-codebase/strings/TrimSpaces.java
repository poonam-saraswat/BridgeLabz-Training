import java.util.Scanner;
public class TrimSpaces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string with leading and trailing spaces: ");
        String inputString = scanner.nextLine();

        // Trim spaces using user-defined method
        int[] trimIndices = trimSpaces(inputString);
        String trimmedUserDefined = substring(inputString, trimIndices[0], trimIndices[1]);

        // Trim spaces using built-in trim() method
        String trimmedBuiltIn = inputString.trim();

        // Compare the two trimmed strings
        boolean areEqual = compareStrings(trimmedUserDefined, trimmedBuiltIn);

        System.out.println("Trimmed using user-defined method: '" + trimmedUserDefined + "'");
        System.out.println("Trimmed using built-in trim() method: '" + trimmedBuiltIn + "'");
        System.out.println("Are both trimmed strings equal? " + areEqual);

        scanner.close();
    }

    public static int[] trimSpaces(String str) {
        int start = 0;
        int end = str.length() - 1;

        // Find the first non-space character from the start
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // Find the first non-space character from the end
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1}; // end + 1 for substring method
    }

    public static String substring(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
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