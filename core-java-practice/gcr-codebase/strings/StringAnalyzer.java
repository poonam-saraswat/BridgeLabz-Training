import java.util.Scanner;

public class StringAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your text:");
        String input = sc.nextLine();

        String[] words = splitText(input);
        int[] lengths = new int[words.length];
        String[][] wordLengthPairs = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int len = getLength(words[i]);
            lengths[i] = len;
            wordLengthPairs[i][0] = words[i];
            wordLengthPairs[i][1] = String.valueOf(len);
        }

        int[] result = findShortestAndLongest(wordLengthPairs);
        System.out.println("Shortest word: " + wordLengthPairs[result[0]][0]);
        System.out.println("Longest word: " + wordLengthPairs[result[1]][0]);
    }

    // Split text into words using charAt()
    public static String[] splitText(String text) {
        String[] temp = new String[100]; // assuming max 100 words
        int wordCount = 0;
        String currentWord = "";

        for (int i = 0; i < getLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                currentWord += ch;
            } else {
                if (!currentWord.equals("")) {
                    temp[wordCount++] = currentWord;
                    currentWord = "";
                }
            }
        }
        if (!currentWord.equals("")) {
            temp[wordCount++] = currentWord;
        }

        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = temp[i];
        }
        return words;
    }

    // Find length without using length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // reached end of string
        }
        return count;
    }

    // Find shortest and longest word
    public static int[] findShortestAndLongest(String[][] wordLengthPairs) {
        int minIndex = 0, maxIndex = 0;
        int min = Integer.parseInt(wordLengthPairs[0][1]);
        int max = Integer.parseInt(wordLengthPairs[0][1]);

        for (int i = 1; i < wordLengthPairs.length; i++) {
            int len = Integer.parseInt(wordLengthPairs[i][1]);
            if (len < min) {
                min = len;
                minIndex = i;
            }
            if (len > max) {
                max = len;
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }
}
