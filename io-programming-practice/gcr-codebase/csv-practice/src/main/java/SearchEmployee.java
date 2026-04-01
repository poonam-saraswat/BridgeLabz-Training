import com.opencsv.CSVReader;
import java.io.FileReader;

public class SearchEmployee {
    public static void main(String[] args) throws Exception {
        String searchName = "Neha";
        CSVReader reader = new CSVReader(new FileReader("data/employees.csv"));
        String[] row;

        reader.readNext();
        while ((row = reader.readNext()) != null) {
            if (row[1].equalsIgnoreCase(searchName)) {
                System.out.println("Department: " + row[2]);
                System.out.println("Salary: " + row[3]);
            }
        }
        reader.close();
    }
}