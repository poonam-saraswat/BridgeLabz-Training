import java.io.*;
import java.util.*;

public class WordCountTop5 {
    public static void main(String[] args) {
        String fileName = "input.txt"; // Replace with your file path

        Map<String, Integer> wordCountMap = new HashMap<>();
        int totalWords = 0;

        // Step 1: Read file using FileReader + BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Split line into words using regex (non-word characters as delimiters)
                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase(); // normalize case
                        totalWords++;

                        // Count occurrences
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
            return;
        }

        // Step 2: Sort words by frequency (descending)
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Step 3: Display results
        System.out.println("Total number of words: " + totalWords);
        System.out.println("Top 5 most frequent words:");

        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedList.get(i);
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " times");
        }
    }
}