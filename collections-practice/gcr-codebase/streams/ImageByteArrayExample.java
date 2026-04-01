import java.io.*;
import java.util.Arrays;

public class ImageByteArrayExample {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";       // original image file
        String destImage = "copy.jpg";           // new image file

        try {
            // Step 1: Read image into byte array using ByteArrayOutputStream
            FileInputStream fis = new FileInputStream(sourceImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            fis.close();

            byte[] imageBytes = baos.toByteArray();
            System.out.println("Image successfully converted to byte array. Size: " + imageBytes.length + " bytes");

            // Step 2: Write byte array back to new image using ByteArrayInputStream
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(destImage);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();
            bais.close();

            System.out.println("Image successfully written to " + destImage);

            // Step 3: Verify both files are identical
            if (compareFiles(sourceImage, destImage)) {
                System.out.println("Verification successful ✅ Both files are identical.");
            } else {
                System.out.println("Verification failed ❌ Files differ.");
            }

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

    // Utility method to compare two files byte by byte
    private static boolean compareFiles(String file1, String file2) throws IOException {
        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        byte[] buf1 = new byte[1024];
        byte[] buf2 = new byte[1024];

        int bytesRead1, bytesRead2;
        while ((bytesRead1 = fis1.read(buf1)) != -1) {
            bytesRead2 = fis2.read(buf2);
            if (bytesRead1 != bytesRead2 || !Arrays.equals(buf1, buf2)) {
                fis1.close();
                fis2.close();
                return false;
            }
        }

        fis1.close();
        fis2.close();
        return true;
    }
}