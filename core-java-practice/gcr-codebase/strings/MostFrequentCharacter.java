import java.util.Scanner;
public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to find the most frequent character: ");
        String inputString = scanner.nextLine();

        char mostFrequentChar = findMostFrequentCharacter(inputString);

        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");

        scanner.close();
    }

    // Method to find the most frequent character in a string
    public static char findMostFrequentCharacter(String str) {
        int[] frequency = new int[256]; // Assuming ASCII character set

        // Count frequency of each character
        for (char c : str.toCharArray()) {
            frequency[c]++;
        }

        // Find the character with the maximum frequency
        char mostFrequent = str.charAt(0);
        int maxCount = frequency[mostFrequent];

        for (char c : str.toCharArray()) {
            if (frequency[c] > maxCount) {
                maxCount = frequency[c];
                mostFrequent = c;
            }
        }

        return mostFrequent;
    }
}