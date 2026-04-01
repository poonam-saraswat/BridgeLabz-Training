import java.util.Scanner;
public class SubstringOccurences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();

        System.out.print("Enter the substring to search for: ");
        String subString = scanner.nextLine();

        int count = countSubstringOccurrences(mainString, subString);

        System.out.println("The substring \"" + subString + "\" occurs " + count + " times in the main string.");

        scanner.close();
    }

    // Method to count occurrences of a substring in a string
    public static int countSubstringOccurrences(String mainString, String subString) {
        int count = 0;
        int index = 0;

        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length(); // Move index forward to avoid counting overlapping occurrences
        }

        return count;
    }
}