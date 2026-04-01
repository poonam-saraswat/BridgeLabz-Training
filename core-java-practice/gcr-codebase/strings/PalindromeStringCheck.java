import java.util.Scanner;
public class PalindromeStringCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check for palindrome: ");
        String inputString = scanner.nextLine();

        boolean isPalindrome = checkPalindrome(inputString);

        if (isPalindrome) {
            System.out.println("\"" + inputString + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + inputString + "\" is not a Palindrome.");
        }

        scanner.close();
    }

    // Method to check if a string is a palindrome
    public static boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }

        return true; // Is a palindrome
    }
}