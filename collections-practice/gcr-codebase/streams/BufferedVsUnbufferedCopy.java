import java.io.*;

public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) {
        // Change these paths as per your system
        String sourceFile = "source.dat";   // Example: large file ~100MB
        String destFileBuffered = "dest_buffered.dat";
        String destFileUnbuffered = "dest_unbuffered.dat";

        // Copy using unbuffered streams
        long startUnbuffered = System.nanoTime();
        copyUnbuffered(sourceFile, destFileUnbuffered);
        long endUnbuffered = System.nanoTime();
        long timeUnbuffered = endUnbuffered - startUnbuffered;

        // Copy using buffered streams
        long startBuffered = System.nanoTime();
        copyBuffered(sourceFile, destFileBuffered);
        long endBuffered = System.nanoTime();
        long timeBuffered = endBuffered - startBuffered;

        // Display results
        System.out.println("Execution Time (Unbuffered): " + timeUnbuffered / 1_000_000 + " ms");
        System.out.println("Execution Time (Buffered):   " + timeBuffered / 1_000_000 + " ms");
    }

    // Method for unbuffered copy
    private static void copyUnbuffered(String source, String dest) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[4096]; // 4 KB chunks
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error (Unbuffered): " + e.getMessage());
        }
    }

    // Method for buffered copy
    private static void copyBuffered(String source, String dest) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[4096]; // 4 KB chunks
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error (Buffered): " + e.getMessage());
        }
    }
}