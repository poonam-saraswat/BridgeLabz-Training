import java.util.Scanner;

public class PalindromeChecker {

    // Logic 1: Compare characters from start and end
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive method
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Compare original and reversed character arrays
    public static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    // Helper method to reverse a string using charAt()
    public static char[] reverseString(String text) {
        char[] reversed = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }
        return reversed;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check for palindrome: ");
        String input = scanner.nextLine();

        System.out.println("\nChecking using three different logics:");

        boolean result1 = isPalindromeIterative(input);
        System.out.println("Logic 1 (Iterative): " + (result1 ? "Palindrome" : "Not Palindrome"));

        boolean result2 = isPalindromeRecursive(input, 0, input.length() - 1);
        System.out.println("Logic 2 (Recursive): " + (result2 ? "Palindrome" : "Not Palindrome"));

        boolean result3 = isPalindromeArray(input);
        System.out.println("Logic 3 (Array Comparison): " + (result3 ? "Palindrome" : "Not Palindrome"));
    }
}
