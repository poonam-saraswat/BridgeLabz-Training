import java.util.Scanner;
public class BMIChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3]; // 10 persons, 3 columns (weight, height, BMI)
        String[] status = new String[10];

        // Taking user input for weight and height
        for (int i = 0; i < data.length; i++) {
            System.out.print("Enter weight (in kg) of person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter height (in cm) of person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
        }

        // Calculating BMI and determining status
        for (int i = 0; i < data.length; i++) {
            data[i][2] = calculateBMI(data[i][0], data[i][1]);
            status[i] = determineBMIStatus(data[i][2]);
        }

        // Displaying the results
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Weight(kg)", "Height(cm)", "BMI", "Status");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s%n", data[i][0], data[i][1], data[i][2], status[i]);
        }

        scanner.close();
    }

    // Method to calculate BMI
    public static double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100; // Convert cm to meters
        return weight / (heightM * heightM);
    }

    // Method to determine BMI status
    public static String determineBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}