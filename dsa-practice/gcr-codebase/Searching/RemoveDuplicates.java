import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Step 1: Take user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 2: Initialize StringBuilder and HashSet
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        // Step 3: Iterate over each character
        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);       // Append if not already seen
                seen.add(c);        // Mark character as seen
            }
        }

        // Step 4: Convert StringBuilder to String
        String result = sb.toString();

        // Output result
        System.out.println("String without duplicates: " + result);

        scanner.close();
    }
}