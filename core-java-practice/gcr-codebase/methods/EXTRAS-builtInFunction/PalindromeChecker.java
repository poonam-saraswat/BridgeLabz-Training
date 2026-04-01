import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = scanner.nextLine();

        boolean isPalindrome = checkPalindrome(input);

        displayResult(input, isPalindrome);

        scanner.close();
    }

    // Method to check whether the string is a palindrome
    public static boolean checkPalindrome(String str) {
        String cleanedStr = str.replaceAll("[\\W]", "").toLowerCase();
        String reversedStr = new StringBuilder(cleanedStr).reverse().toString();
        return cleanedStr.equals(reversedStr);
    }

    // Method to display the result
    public static void displayResult(String str, boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("\"" + str + "\" is a palindrome.");
        } else {
            System.out.println("\"" + str + "\" is not a palindrome.");
        }
    }
}