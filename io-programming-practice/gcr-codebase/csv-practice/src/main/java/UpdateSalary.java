import com.opencsv.*;
import java.io.*;

public class UpdateSalary {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader("data/employees.csv"));
        CSVWriter writer = new CSVWriter(new FileWriter("data/output/updated-employees.csv"));

        String[] row;
        writer.writeNext(reader.readNext());

        while ((row = reader.readNext()) != null) {
            if (row[2].equalsIgnoreCase("IT")) {
                double salary = Double.parseDouble(row[3]);
                row[3] = String.valueOf(salary * 1.10);
            }
            writer.writeNext(row);
        }
        reader.close();
        writer.close();
    }
}