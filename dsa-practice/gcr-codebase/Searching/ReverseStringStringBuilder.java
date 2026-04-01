import java.util.Scanner;

public class ReverseStringStringBuilder {
    public static void main(String[] args) {
        // Step 1: Create Scanner object to take input from user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();  // Read user input

        // Step 2: Create a StringBuilder object and append the string
        StringBuilder sb = new StringBuilder();
        sb.append(input);

        // Step 3: Use reverse() method
        sb.reverse();

        // Step 4: Convert back to string
        String reversed = sb.toString();

        // Output result
        System.out.println("Reversed String: " + reversed);

        // Close scanner
        scanner.close();
    }
}