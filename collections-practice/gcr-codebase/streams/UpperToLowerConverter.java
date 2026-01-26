import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        String sourceFile = "input.txt";      // source file
        String destFile = "output.txt";       // destination file

        // Use try-with-resources for automatic closing
        try (
            BufferedReader br = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert to lowercase
                String lowerLine = line.toLowerCase();
                bw.write(lowerLine);
                bw.newLine(); // preserve line breaks
            }

            System.out.println("File converted successfully! Output saved in " + destFile);

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}