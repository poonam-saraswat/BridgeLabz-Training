import java.util.Scanner;
public class BMI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of persons:");
        int n = sc.nextInt();

        double[][] personData = new double[n][3]; // 0: height, 1: weight, 2: BMI
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            double height, weight;

            while (true) {
                System.out.println("Enter height (in meters) of person " + (i + 1) + ":");
                height = sc.nextDouble();
                if (height > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive value for height.");
                }
            }

            while (true) {
                System.out.println("Enter weight (in kg) of person " + (i + 1) + ":");
                weight = sc.nextDouble();
                if (weight > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive value for weight.");
                }
            }

            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = weight / (height * height); // Calculate BMI

            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(m)", "Weight(kg)", "BMI", "Status");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s%n", personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        sc.close();
    }
}