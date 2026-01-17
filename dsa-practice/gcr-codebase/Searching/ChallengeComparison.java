import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class ChallengeComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Part 1: StringBuilder vs StringBuffer
    
        System.out.print("Enter the string to concatenate: ");
        String str = scanner.nextLine();

        int iterations = 1_000_000; // fixed as per problem

        // StringBuilder test
        StringBuilder sb = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sb.append(str);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        // StringBuffer test
        StringBuffer sbf = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sbf.append(str);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        System.out.println("\n=== String Concatenation Performance ===");
        System.out.println("StringBuilder time: " + timeBuilder + " nanoseconds");
        System.out.println("StringBuffer time: " + timeBuffer + " nanoseconds");
     
        // Part 2: FileReader vs InputStreamReader

        System.out.print("\nEnter the file path to read (large file ~100MB): ");
        String filePath = scanner.nextLine();

        // FileReader test
        int wordCountFR = 0;
        long startFR = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCountFR += words.length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        long endFR = System.nanoTime();
        long timeFR = endFR - startFR;

        // InputStreamReader test
        int wordCountISR = 0;
        long startISR = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCountISR += words.length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        long endISR = System.nanoTime();
        long timeISR = endISR - startISR;

        System.out.println("\n=== File Reading Performance ===");
        System.out.println("FileReader word count: " + wordCountFR + ", time: " + timeFR + " nanoseconds");
        System.out.println("InputStreamReader word count: " + wordCountISR + ", time: " + timeISR + " nanoseconds");

        scanner.close();
    }
}