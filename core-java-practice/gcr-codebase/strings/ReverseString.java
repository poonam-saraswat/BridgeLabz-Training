import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String inputString = scanner.nextLine();

        String reversedString = reverseString(inputString);

        System.out.println("Reversed String: " + reversedString);

        scanner.close();
    }

    // Method to reverse a string
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }
}