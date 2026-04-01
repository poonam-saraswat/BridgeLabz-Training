import java.util.Scanner;
public class SplitText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Split text using user-defined method
        String[] userDefinedWords = splitText(inputString);

        // Split text using built-in split() method
        String[] builtInWords = inputString.split(" ");

        boolean areEqual = compareStringArrays(userDefinedWords, builtInWords);

        System.out.println("Words from user-defined method:");
        for (String word : userDefinedWords) {
            System.out.println(word);
        }

        System.out.println("Words from built-in split() method:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("Are both word arrays equal? " + areEqual);

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

    // Method to compare two string arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
}