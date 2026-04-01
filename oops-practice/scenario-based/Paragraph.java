import java.util.*;
public class Paragraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a paragraph of text:");
        String paragraph = scanner.nextLine();

        if (paragraph.trim().isEmpty()) {
            System.out.println("The paragraph is empty or contains only spaces.");
        } else {
            int wordCount = countWords(paragraph);
            String longestWord = findLongestWord(paragraph);
            System.out.print("Enter the word to be replaced: ");
            String wordToReplace = scanner.nextLine();
            System.out.print("Enter the new word: ");
            String newWord = scanner.nextLine();
            String modifiedParagraph = replaceWord(paragraph, wordToReplace, newWord);

            System.out.println("Number of words: " + wordCount);
            System.out.println("Longest word: " + longestWord);
            System.out.println("Modified Paragraph: " + modifiedParagraph);
        }

        scanner.close();
    }

    // Method to count the number of words in the paragraph
    public static int countWords(String paragraph) {
        String[] words = paragraph.trim().split("\\s+");
        return words.length;
    }

    // Method to find the longest word in the paragraph
    public static String findLongestWord(String paragraph) {
        String[] words = paragraph.trim().split("\\s+");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    // Method to replace all occurrences of a specific word with another word (case-insensitive)
    public static String replaceWord(String paragraph, String oldWord, String newWord) {
        return paragraph.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
    }
}
