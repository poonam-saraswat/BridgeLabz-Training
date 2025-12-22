import java.util.Scanner;
public class NonRepeatingChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        char firstNonRepeatingChar = findFirstNonRepeatingChar(inputString);

        if (firstNonRepeatingChar != '\0') {
            System.out.println("The first non-repeating character is: " + firstNonRepeatingChar);
        } else {
            System.out.println("There are no non-repeating characters in the string.");
        }

        scanner.close();
    }

    public static char findFirstNonRepeatingChar(String str) {
        int[] charCount = new int[256]; // ASCII character set

        // Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i)]++;
        }

        // Find the first non-repeating character
        for (int i = 0; i < str.length(); i++) {
            if (charCount[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return '\0'; // Return null character if no non-repeating character found
    }
}