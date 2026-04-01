import java.util.*;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupEmployeesByDepartment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Take user input for employees
        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();

            System.out.print("Enter department: ");
            String department = scanner.nextLine();

            employees.add(new Employee(name, department));
        }

        // Group employees by department
        Map<String, List<Employee>> groupedByDept = new HashMap<>();

        for (Employee emp : employees) {
            groupedByDept
                .computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>())
                .add(emp);
        }

        // Print grouped employees
        System.out.println("\nEmployees grouped by department:");
        for (Map.Entry<String, List<Employee>> entry : groupedByDept.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}