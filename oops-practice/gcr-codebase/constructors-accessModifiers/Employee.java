import java.util.*;
class Employee {
    // Static variable shared by all employees
    static String companyName = "Tech Solutions Inc.";
    static int totalEmployees = 0;

    // Final variable for employee ID
    final int id;
    String name;
    String designation;

    // Constructor using 'this' to initialize instance variables
    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method to display total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
    }
}
class EmployeeTest {
    public static void main(String[] args) {
        // Creating Employee objects
        Employee emp1 = new Employee(101, "Thamarai", "Software Engineer");
        Employee emp2 = new Employee(102, "Rohan", "Project Manager");

        // Displaying total number of employees
        Employee.displayTotalEmployees();

        // Checking instanceof and displaying details for emp1
        if (emp1 instanceof Employee) {
            emp1.displayDetails();
        }

        // Checking instanceof and displaying details for emp2
        if (emp2 instanceof Employee) {
            emp2.displayDetails();
        }
    }
}

