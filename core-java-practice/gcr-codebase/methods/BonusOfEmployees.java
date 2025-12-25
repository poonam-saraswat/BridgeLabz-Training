import java.util.*;
public class BonusOfEmployees {
    public static void main(String[] args) {
        final int NUM_EMPLOYEES = 10;
        double[][] employeeData = new double[NUM_EMPLOYEES][2]; // [][0] = salary, [][1] = years of service

        // Populate employee data with random salaries and years of service
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            employeeData[i][0] = Math.floor(10000 + Math.random() * 90000); // 5-digit salary
            employeeData[i][1] = Math.floor(Math.random() * 11); // years of service between 0 and 10
        }

        double[][] updatedEmployeeData = calculateNewSalaryAndBonus(employeeData);
        displaySalaryAndBonus(employeeData, updatedEmployeeData);
    }

    // Method to calculate the new salary and bonus
    public static double[][] calculateNewSalaryAndBonus(double[][] data) {
        double[][] newData = new double[data.length][3]; // [][0] = old salary, [][1] = new salary, [][2] = bonus

        for (int i = 0; i < data.length; i++) {
            double oldSalary = data[i][0];
            double yearsOfService = data[i][1];
            double bonus;

            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05;
            } else {
                bonus = oldSalary * 0.02;
            }

            double newSalary = oldSalary + bonus;

            newData[i][0] = oldSalary;
            newData[i][1] = newSalary;
            newData[i][2] = bonus;
        }

        return newData;
    }

    // Method to display the salary and bonus in tabular format
    public static void displaySalaryAndBonus(double[][] oldData, double[][] newData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.printf("%-15s %-15s %-15s %-15s%n", "Old Salary", "New Salary", "Bonus", "Years of Service");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < oldData.length; i++) {
            double oldSalary = newData[i][0];
            double newSalary = newData[i][1];
            double bonus = newData[i][2];
            double yearsOfService = oldData[i][1];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%-15.2f %-15.2f %-15.2f %-15.0f%n", oldSalary, newSalary, bonus, yearsOfService);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-15.2f %-15.2f %-15.2f%n", totalOldSalary, totalNewSalary, totalBonus); 
    }
}