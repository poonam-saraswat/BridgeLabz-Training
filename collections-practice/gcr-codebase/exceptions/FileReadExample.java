import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
    public static void main(String[] args) {
        try {
            // Attempt to open and read the file "data.txt"
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line;
            
            // Print file contents line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            reader.close();
        } catch (IOException e) {
            // Handle the checked exception gracefully
            System.out.println("File not found");
        }
    }
}