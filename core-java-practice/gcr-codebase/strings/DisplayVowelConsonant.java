import java.util.Scanner;
public class DisplayVowelConsonant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Get character types using user-defined method
        String[][] charTypes = getVowelConsonantTypes(inputString);

        // Display the result in tabular format
        displayCharTypes(charTypes);

        scanner.close();
    }

    public static String[][] getVowelConsonantTypes(String str) {
        String[][] result = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String type = checkVowelOrConsonant(ch);
            result[i][0] = String.valueOf(ch);
            result[i][1] = type;
        }
        return result;
    }

    public static String checkVowelOrConsonant(char ch) {
        // Convert to lowercase if uppercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if character is a letter
        if (ch >= 'a' && ch <= 'z') {
            // Check for vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    public static void displayCharTypes(String[][] charTypes) {
        System.out.printf("%-10s %-15s%n", "Character", "Type");
        System.out.println("-------------------------");
        for (String[] pair : charTypes) {
            System.out.printf("%-10s %-15s%n", pair[0], pair[1]);
        }
    }
}