import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources{
    public static void main(String[] args) {
        // Using try-with-resources to auto-close BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {
            
            // Read the first line of the file
            String firstLine = br.readLine();
            
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
            
        } catch (IOException e) {
            // Handle IOException (file not found or read error)
            System.out.println("Error reading file");
        }
    }
}