import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take file path and charset from user
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the charset (e.g., UTF-8): ");
        String charset = scanner.nextLine();

        BufferedReader reader = null;

        try {
            // Step 2: Create FileInputStream
            FileInputStream fis = new FileInputStream(filePath);

            // Step 3: Wrap FileInputStream in InputStreamReader with charset
            InputStreamReader isr = new InputStreamReader(fis, charset);

            // Step 4: Wrap InputStreamReader in BufferedReader
            reader = new BufferedReader(isr);

            // Step 5: Read file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            // Step 6: Close resources
            try {
                if (reader != null) {
                    reader.close();
                }
                scanner.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}