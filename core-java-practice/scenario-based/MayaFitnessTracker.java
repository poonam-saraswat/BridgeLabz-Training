import java.util.Scanner;
public class MayaFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of clients:");
        int n = sc.nextInt();

        double[] heights = new double[n];
        double[] weights = new double[n];
        double[] bmis = new double[n];
        String[] categories = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter height (in meters) of client " + (i + 1) + ":");
            heights[i] = sc.nextDouble();
            System.out.println("Enter weight (in kg) of client " + (i + 1) + ":");
            weights[i] = sc.nextDouble();

            bmis[i] = weights[i] / (heights[i] * heights[i]);

            if (bmis[i] < 18.5) {
                categories[i] = "Underweight";
            } else if (bmis[i] < 24.9) {
                categories[i] = "Normal weight";
            } else if (bmis[i] < 29.9) {
                categories[i] = "Overweight";
            } else {
                categories[i] = "Obesity";
            }
        }

        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(m)", "Weight(kg)", "BMI", "Category");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s%n", heights[i], weights[i], bmis[i], categories[i]);
        }

        sc.close();
    }
}