
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) throws Exception {
        Set<String> seen = new HashSet<>();
        CSVReader reader = new CSVReader(new FileReader("data/students.csv"));
        String[] row;

        reader.readNext();
        while ((row = reader.readNext()) != null) {
            if (!seen.add(row[0])) {
                System.out.println("Duplicate ID: " + String.join(", ", row));
            }
        }
        reader.close();
    }
}
