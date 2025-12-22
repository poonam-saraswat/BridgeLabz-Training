import java.util.Scanner;
public class SplitText2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Split text using user-defined method
        String[] words = splitText(inputString);

        // Get 2D array of words and their lengths
        String[][] wordsWithLengths = getWordsWithLengths(words);

        // Display the result in tabular format
        System.out.printf("%-20s %-10s%n", "Word", "Length");
        System.out.println("-------------------- ----------");
        for (String[] wordInfo : wordsWithLengths) {
            System.out.printf("%-20s %-10s%n", wordInfo[0], wordInfo[1]);
        }

        scanner.close();
    }

    public static String[] splitText(String str) {
        int wordCount = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                currentWord.append(ch);
            } else {
                words[wordIndex++] = currentWord.toString();
                currentWord.setLength(0);
            }
        }
        words[wordIndex] = currentWord.toString(); // Add the last word

        return words;
    }

    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Exception caught when index is out of bounds
        }
        return count;
    }

    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getStringLength(words[i]));
        }
        return result;
    }
}