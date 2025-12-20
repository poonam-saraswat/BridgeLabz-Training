import java.util.*;
public class HeightOfPlayers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;

        System.out.println("Enter the heights of 11 players in meters:");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }

        double meanHeight = sum / heights.length;
        System.out.printf("The mean height of the football team players is: %.2f meters%n", meanHeight);
        sc.close();
    }
}