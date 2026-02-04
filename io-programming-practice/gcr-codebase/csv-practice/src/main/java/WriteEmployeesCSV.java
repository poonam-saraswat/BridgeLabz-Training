import com.opencsv.CSVWriter;
import java.io.FileWriter;

public class WriteEmployeesCSV {
    public static void main(String[] args) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter("data/employees.csv"));

        writer.writeNext(new String[]{"ID","Name","Department","Salary"});
        writer.writeNext(new String[]{"1","Aman","IT","60000"});
        writer.writeNext(new String[]{"2","Riya","HR","50000"});
        writer.writeNext(new String[]{"3","Neha","IT","65000"});
        writer.writeNext(new String[]{"4","Arjun","Sales","55000"});
        writer.writeNext(new String[]{"5","Karan","IT","70000"});

        writer.close();
    }
}