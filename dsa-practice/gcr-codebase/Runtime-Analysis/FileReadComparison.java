import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReadComparison {

    // Read using FileReader (Character Stream)
    public static void readWithFileReader(File file) throws IOException {
        FileReader fr = new FileReader(file);
        int ch;
        while ((ch = fr.read()) != -1) {
            // Just reading, not storing
        }
        fr.close();
    }

    // Read using InputStreamReader (Byte Stream -> Character Stream)
    public static void readWithInputStreamReader(File file) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        int ch;
        while ((ch = isr.read()) != -1) {
            // Just reading, not storing
        }
        isr.close();
    }

    // Utility: Run experiment
    public static void runExperiment(String filePath) throws IOException {
        File file = new File(filePath);

        // FileReader timing
        long start = System.nanoTime();
        readWithFileReader(file);
        long end = System.nanoTime();
        double fileReaderTime = (end - start) / 1e6; // ms

        // InputStreamReader timing
        start = System.nanoTime();
        readWithInputStreamReader(file);
        end = System.nanoTime();
        double inputStreamReaderTime = (end - start) / 1e6; // ms

        System.out.printf("File: %s | FileReader: %.2f ms | InputStreamReader: %.2f ms%n",
                file.getName(), fileReaderTime, inputStreamReaderTime);
    }

    public static void main(String[] args) {
        try {
            // Provide path to a large file (e.g., 500MB text file)
            String filePath = "largefile.txt"; // <-- replace with actual file path
            runExperiment(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}