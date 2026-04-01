import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee{
    private String name;
    private String department;
    private double salary;

    public Employee(String name,String department, double salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName(){ return name; }
    public String getDepartment(){ return department; }
    public double getSalary(){ return salary; }
}

public class EmployeeSalary {
    public static void main(String[] args){
        List<Employee> employees = List.of(
            new Employee("Alice","Marketing", 20000.0),
            new Employee("Bob", "Technical", 35000.0),
            new Employee("Claude", "Marketing", 22000.0),
            new Employee("Olive", "Technical", 45000.0),
            new Employee("Harper", "Management", 25000.0)
        );

        Map<String, Double> map = employees.stream()
            .collect(
                Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.averagingDouble(Employee::getSalary)
                )
            );

        map.forEach((dep, salary) -> 
            System.out.println(dep + " - " + salary)
        );
    }    
}
