import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to remove duplicates: ");
        String inputString = scanner.nextLine();

        String resultString = removeDuplicates(inputString);

        System.out.println("String after removing duplicates: " + resultString);

        scanner.close();
    }

    // Method to remove duplicate characters from a string
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256]; // Assuming ASCII character set

        for (char c : str.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                result.append(c);
            }
        }

        return result.toString();
    }
}