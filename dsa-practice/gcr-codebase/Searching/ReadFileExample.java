import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take file path from user
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        BufferedReader reader = null;

        try {
            // Step 2: Create FileReader and wrap it in BufferedReader
            FileReader fr = new FileReader(filePath);
            reader = new BufferedReader(fr);

            // Step 3: Read file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            // Step 4: Close resources
            try {
                if (reader != null) {
                    reader.close();
                }
                scanner.close();
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}