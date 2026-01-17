import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCountInFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take file path and target word from user
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the word to count: ");
        String targetWord = scanner.nextLine();

        int count = 0; // counter for occurrences

        BufferedReader reader = null;

        try {
            // Step 2: Create FileReader and wrap it in BufferedReader
            FileReader fr = new FileReader(filePath);
            reader = new BufferedReader(fr);

            // Step 3: Read file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line into words
                String[] words = line.split("\\s+"); // split by whitespace
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) { // case-insensitive match
                        count++;
                    }
                }
            }

            // Step 4: Print result
            System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            // Step 5: Close resources
            try {
                if (reader != null) {
                    reader.close();
                }
                scanner.close();
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}