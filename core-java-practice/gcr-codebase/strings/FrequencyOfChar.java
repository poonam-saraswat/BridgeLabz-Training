import java.util.Scanner;
public class FrequencyOfChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Get frequency of characters using user-defined method
        String[][] frequencyArray = getCharacterFrequencies(inputString);

        System.out.println("Character Frequencies:");
        for (String[] pair : frequencyArray) {
            System.out.println("Character: '" + pair[0] + "' Frequency: " + pair[1]);
        }

        scanner.close();
    }

    public static String[][] getCharacterFrequencies(String str) {
        int[] charCount = new int[256]; // ASCII character set

        // Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i)]++;
        }

        // Count unique characters
        int uniqueCharCount = 0;
        for (int count : charCount) {
            if (count > 0) {
                uniqueCharCount++;
            }
        }
        String[][] result = new String[uniqueCharCount][2];
        int index = 0;
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0) {
                result[index][0] = Character.toString((char) i);
                result[index][1] = Integer.toString(charCount[i]);
                index++;
            }
        }

        return result;
    }
}