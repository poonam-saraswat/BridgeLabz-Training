public class EmployeeDetails {
    // Attributes
    private String name;
    private int id;
    private double salary;

    // Constructor
    public EmployeeDetails(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    // Main method to test the Employee class
    public static void main(String[] args) {
        // Creating an Employee object
        EmployeeDetails employee = new EmployeeDetails("Rohan", 1, 500000);

        // Displaying employee details
        employee.displayDetails();
    }
}