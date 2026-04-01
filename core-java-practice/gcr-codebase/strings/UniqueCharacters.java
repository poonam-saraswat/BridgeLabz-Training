import java.util.Scanner;
public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Find unique characters using user-defined method
        char[] uniqueChars = findUniqueCharacters(inputString);

        System.out.print("Unique characters in the string: ");
        for (char ch : uniqueChars) {
            System.out.print(ch + " ");
        }

        scanner.close();
    }

    public static char[] findUniqueCharacters(String str) {
        int length = getLength(str);
        char[] temp = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = str.charAt(i);
            boolean isUnique = true;

            // Check if currentChar is already in temp array
            for (int j = 0; j < uniqueCount; j++) {
                if (temp[j] == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            // If unique, add to temp array
            if (isUnique) {
                temp[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        // Create result array of exact size
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    // Method to find length without using length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Reached the end of the string
        }
        return count;
    }
}