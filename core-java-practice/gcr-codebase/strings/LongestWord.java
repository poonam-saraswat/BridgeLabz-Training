import java.util.Scanner;
public class LongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String longestWord = findLongestWord(sentence);

        System.out.println("The longest word is: " + longestWord);

        scanner.close();
    }

    // Method to find the longest word in a sentence
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }
}