import java.util.Scanner;
public class CompareTwoStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter String 1: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter String 2: ");
        String str2 = scanner.nextLine();

        int comparisonResult = compareStrings(str1, str2);

        if (comparisonResult < 0) {
            System.out.println("\"" + str1 + "\" is lexicographically smaller than \"" + str2 + "\".");
        } else if (comparisonResult > 0) {
            System.out.println("\"" + str1 + "\" is lexicographically greater than \"" + str2 + "\".");
        } else {
            System.out.println("Both strings are equal.");
        }

        scanner.close();
    }

    // Method to compare two strings lexicographically
    public static int compareStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int minLength = Math.min(len1, len2);

        for (int i = 0; i < minLength; i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (char1 != char2) {
                return char1 - char2; // Return the difference of the first non-matching characters
            }
        }

        // If all characters are the same up to the length of the shorter string,
        // the shorter string is considered smaller
        return len1 - len2;
    }
}