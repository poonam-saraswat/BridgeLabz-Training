import java.util.Scanner;

// Abstract base class
abstract class Employee {
    private final String name;
    private final double salary;
    private final double bonus; // cached bonus

    // Constructor calculates and caches bonus
    public Employee(String name, double salary) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (salary < 0.0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.name = name;
        this.salary = salary;
        this.bonus = computeBonus(); // cache at construction
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Cached getter
    public double getBonus() {
        return bonus;
    }

    // Abstract method for subclasses to implement bonus logic
    protected abstract double computeBonus();
}

// Manager subclass
class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    protected double computeBonus() {
        // Manager bonus = 10% of salary
        return getSalary() * 0.10;
    }
}

// Developer subclass
class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    protected double computeBonus() {
        // Developer bonus = 5% if salary > 50000, else 0
        return getSalary() > 50000.0 ? getSalary() * 0.05 : 0.0;
    }
}

// Demo class with user input
public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter role (Manager/Developer): ");
        String role = sc.nextLine().trim();

        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        Employee emp;

        // Create appropriate subclass based on role
        if (role.equalsIgnoreCase("Manager")) {
            emp = new Manager(name, salary);
        } else if (role.equalsIgnoreCase("Developer")) {
            emp = new Developer(name, salary);
        } else {
            System.out.println("Invalid role entered!");
            sc.close();
            return;
        }

        // Output bonus
        System.out.printf("Bonus for %s (%s): %.2f%n", emp.getName(), role, emp.getBonus());

        sc.close();
    }
}