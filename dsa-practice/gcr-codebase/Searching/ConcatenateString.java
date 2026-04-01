import java.util.Scanner;

public class ConcatenateString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Ask how many strings the user wants to enter
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Step 2: Create a StringBuffer
        StringBuffer sb = new StringBuffer();

        // Step 3: Take user input for each string and append
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            String input = scanner.nextLine();
            sb.append(input).append(" "); // add space for readability
        }

        // Step 4: Convert to string and trim trailing space
        String result = sb.toString().trim();

        // Output result
        System.out.println("Concatenated String: " + result);

        scanner.close();
    }
}