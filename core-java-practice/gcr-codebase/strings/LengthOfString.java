import java.util.Scanner;
public class LengthOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Get length using user-defined method
        int userDefinedLength = getStringLength(inputString);

        // Get length using built-in length() method
        int builtInLength = inputString.length();

        System.out.println("Length using user-defined method: " + userDefinedLength);
        System.out.println("Length using built-in length() method: " + builtInLength);

        scanner.close();
    }

    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Exception caught when index is out of bounds
        }
        return count;
    }
}