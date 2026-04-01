import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            // Step 1: Create InputStreamReader to read from console
            InputStreamReader isr = new InputStreamReader(System.in);
            reader = new BufferedReader(isr);

            // Step 2: Ask user for file path
            System.out.print("Enter the file path to save input: ");
            String filePath = reader.readLine();

            // Step 3: Create FileWriter
            writer = new FileWriter(filePath);

            System.out.println("Start typing your input (type 'exit' to stop):");

            // Step 4: Read user input and write to file
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) {
                    break; // stop when user types "exit"
                }
                writer.write(line + System.lineSeparator()); // write each line
            }

            System.out.println("Input successfully written to file: " + filePath);

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            // Step 5: Close resources
            try {
                if (writer != null) {
                    writer.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}