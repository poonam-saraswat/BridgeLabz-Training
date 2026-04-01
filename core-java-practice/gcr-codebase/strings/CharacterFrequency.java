import java.util.Scanner;

public class CharacterFrequency {

    // Method to find unique characters in the string
    public static char[] findUniqueCharacters(String text) {
        String unique = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique += ch;
            }
        }
        return unique.toCharArray();
    }

    // Method to calculate frequency of each unique character
    public static String[][] calculateFrequency(String text) {
        int[] freq = new int[256]; // ASCII size

        // Count frequency using ASCII index
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] uniqueChars = findUniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }

    public static void displayResult(String[][] result) {
        System.out.printf("%-10s %-10s%n", "Character", "Frequency");
        System.out.println("------------------------");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-10s %-10s%n", result[i][0], result[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String[][] result = calculateFrequency(text);
        displayResult(result);
    }
}
