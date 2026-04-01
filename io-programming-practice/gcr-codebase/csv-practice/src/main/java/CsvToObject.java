import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class CsvToObject {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader("data/students.csv"));
        String[] row;

        reader.readNext();
        while ((row = reader.readNext()) != null) {
            students.add(new Student(
                Integer.parseInt(row[0]),
                row[1],
                Integer.parseInt(row[2]),
                Integer.parseInt(row[3])
            ));
        }
        reader.close();
        students.forEach(System.out::println);
    }
}