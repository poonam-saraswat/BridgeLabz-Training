import java.util.Scanner;

public class SearchWordInSentences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take number of sentences
        System.out.print("Enter the number of sentences: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] sentences = new String[n];

        // Step 2: Input sentences
        System.out.println("Enter " + n + " sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }

        // Step 3: Input the word to search
        System.out.print("Enter the word to search: ");
        String targetWord = scanner.nextLine();

        // Step 4: Perform linear search
        String result = "Not Found";
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(targetWord.toLowerCase())) {
                result = sentence;
                break; // stop at the first match
            }
        }

        // Step 5: Output result
        System.out.println("Result: " + result);

        scanner.close();
    }
}