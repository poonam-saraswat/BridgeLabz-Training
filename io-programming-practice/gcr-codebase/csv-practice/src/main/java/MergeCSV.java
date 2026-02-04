
import com.opencsv.*;
import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) throws Exception {
        Map<String, String[]> map = new HashMap<>();

        CSVReader r1 = new CSVReader(new FileReader("data/student1.csv"));
        CSVReader r2 = new CSVReader(new FileReader("data/student2.csv"));
        CSVWriter w = new CSVWriter(new FileWriter("data/output/merged-students.csv"));

        r1.readNext();
        r2.readNext();
        String[] row;

        while ((row = r1.readNext()) != null)
            map.put(row[0], row);

        while ((row = r2.readNext()) != null) {
            String[] s = map.get(row[0]);
            if (s != null)
                w.writeNext(new String[]{s[0], s[1], s[2], row[1], row[2]});
        }

        r1.close(); r2.close(); w.close();
    }
}
