import java.io.*;

public class LargeFileErrorReader {
    public static void main(String[] args) {
        String fileName = "largefile.txt"; // Replace with your actual file path

        // Use try-with-resources for automatic closing
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Case-insensitive check for "error"
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}