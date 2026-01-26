import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for source and destination file names
        System.out.print("Enter source file name (with path if needed): ");
        String sourceFileName = sc.nextLine();

        System.out.print("Enter destination file name (with path if needed): ");
        String destFileName = sc.nextLine();

        File sourceFile = new File(sourceFileName);
        File destFile = new File(destFileName);

        // Check if source file exists
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist!");
            return;
        }

        // File handling with try-with-resources
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully to " + destFileName);

        } catch (IOException e) {
            System.out.println("An error occurred while handling the file: " + e.getMessage());
        }

        sc.close();
    }
}