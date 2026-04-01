import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for file path
        System.out.print("Enter the path of the text file: ");
        String filePath = scanner.nextLine();

        // HashMap to store word frequencies
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                line = line.replaceAll("[^a-zA-Z ]", " ").toLowerCase();

                // Split line into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Print word frequencies
            System.out.println("Word Frequencies:");
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}