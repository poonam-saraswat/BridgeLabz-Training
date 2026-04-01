import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;

class Employee{
    int employeeId;
    String employeeName;
    String designation;

    public Employee(int employeeId, String employeeName, String designation){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }
}

public class ListObjectsIntoJson{
    public static void main(String[] args){
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(1, "Alice","HR");
        Employee e2 = new Employee(2, "Bob", "Software Engineer");
        Employee e3 = new Employee(3, "Olive", "Marketing Intern");
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        JSONArray employeeArray = new JSONArray();

        for(int i = 0; i < employees.size(); i++){
            Employee e = employees.get(i);
            JSONObject json = new JSONObject();
            json.put("EmployeeId", e.employeeId);
            json.put("EmployeeName", e.employeeName);
            json.put("Designation", e.designation);

            employeeArray.put(json);
        }

        try(FileWriter writer = new FileWriter("data/Employee.json")){
            writer.write(employeeArray.toString());
            System.out.println("Converted list of objects into a json file");
        }
        catch(IOException e){
            System.out.println("Error!");
        }
    }
}