import java.io.*;
import java.util.*;

// Employee class must implement Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // good practice for Serializable classes
    
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // toString method for display
    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + 
               ", Department=" + department + ", Salary=" + salary + "]";
    }
}

public class EmployeeSerializationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = Integer.parseInt(sc.nextLine());

        // Collect employee details from user
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String dept = sc.nextLine();

            System.out.print("Salary: ");
            double salary = Double.parseDouble(sc.nextLine());

            employees.add(new Employee(id, name, dept, salary));
        }

        String filename = "employees.ser";

        // Serialize the list of employees
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("\nEmployees have been serialized into " + filename);
        } catch (IOException e) {
            System.out.println("IOException during serialization: " + e.getMessage());
        }

        // Deserialize the list of employees
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employees:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            System.out.println("IOException during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }

        sc.close();
    }
}