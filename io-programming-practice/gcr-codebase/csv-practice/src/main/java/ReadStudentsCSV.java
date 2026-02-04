import com.opencsv.CSVReader;
import java.io.FileReader;

public class ReadStudentsCSV {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader("data/students.csv"));
        String[] row;

        reader.readNext(); 
        while ((row = reader.readNext()) != null) {
            System.out.println(
                "ID: " + row[0] +
                ", Name: " + row[1] +
                ", Age: " + row[2] +
                ", Marks: " + row[3]
            );
        }
        reader.close();
    }
}
