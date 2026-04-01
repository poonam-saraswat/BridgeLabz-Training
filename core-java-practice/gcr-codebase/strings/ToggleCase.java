import java.util.Scanner;
public class ToggleCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to toggle case: ");
        String inputString = scanner.nextLine();

        String toggledString = toggleCase(inputString);

        System.out.println("Toggled Case String: " + toggledString);

        scanner.close();
    }

    // Method to toggle the case of each character in the string
    public static String toggleCase(String str) {
        StringBuilder toggled = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                toggled.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                toggled.append(Character.toUpperCase(ch));
            } else {
                toggled.append(ch); // Non-alphabetic characters remain unchanged
            }
        }

        return toggled.toString();
    }
}