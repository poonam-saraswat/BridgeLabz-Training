import java.util.*;
public class TemperatureAnalyzer {  
    public static void main(String[] args) {
        // Sample temperature data for a week (7 days, 24 hours each)
        float[][] temperatures = {
            {30.5f, 32.0f, 31.5f, 29.0f, 28.5f, 27.0f, 26.5f, 25.0f, 24.5f, 23.0f, 22.5f, 21.0f,
             20.5f, 19.0f, 18.5f, 17.0f, 16.5f, 15.0f, 14.5f, 13.0f, 12.5f, 11.0f, 10.5f, 9.0f},
            {31.0f, 33.5f, 32.0f, 30.0f, 29.5f, 28.0f, 27.5f, 26.0f, 25.5f, 24.0f, 23.5f, 22.0f,
             21.5f, 20.0f, 19.5f, 18.0f, 17.5f, 16.0f, 15.5f, 14.0f, 13.5f, 12.0f, 11.5f, 10.0f},
            {29.5f, 31.0f, 30.5f, 28.0f, 27.5f, 26.0f, 25.5f, 24.0f, 23.5f, 22.0f, 21.5f, 20.0f,
             19.5f, 18.0f, 17.5f, 16.0f, 15.5f, 14.0f, 13.5f, 12.0f, 11.5f, 10.0f, 9.5f, 8.0f},
            {32.0f, 34.0f, 33.0f, 31.0f, 30.5f, 29.0f, 28.5f, 27.0f, 26.5f, 25.0f, 24.5f, 23.0f,
             22.5f, 21.0f, 20.5f, 19.0f, 18.5f, 17.0f, 16.5f, 15.0f, 14.5f, 13.0f, 12.5f, 11.0f},
            {28.0f, 30.0f, 29.0f, 27.0f, 26.5f, 25.0f, 24.5f, 23.0f, 22.5f, 21.0f, 20.5f, 19.0f,
             18.5f, 17.0f, 16.5f, 15.0f, 14.5f, 13.0f, 12.5f, 11.0f, 10.5f, 9.0f, 8.5f, 7.0f},
            {33.0f, 35.0f, 34.0f, 32.0f, 31.5f, 30.0f, 29.5f, 28.0f, 27.5f, 26.0f, 25.5f, 24.0f,
             23.5f, 22.0f, 21.5f, 20.0f, 19.5f, 18.0f, 17.5f, 16.0f, 15.5f, 14.0f, 13.5f, 12.0f},
            {27.5f, 29.0f, 28.5f, 26.0f, 25.5f, 24.0f, 23.5f, 22.0f, 21.5f, 20.0f,
             19.5f, 18.0f, 17.5f, 16.0f, 15.5f, 14.0f, 13.5f, 12.0f,
             11.5f, 10.0f, 9.5f, 8.0f, 7.5f}
        };
        findHottestAndColdestDay(temperatures);
        calculateAverageTemperaturePerDay(temperatures);    
    }
    // Method to find the hottest and coldest day
    public static void findHottestAndColdestDay(float[][] temps) {
        float maxTemp = Float.NEGATIVE_INFINITY;
        float minTemp = Float.POSITIVE_INFINITY;
        int hottestDay = -1;
        int coldestDay = -1;

        for (int day = 0; day < temps.length; day++) {
            for (int hour = 0; hour < temps[day].length; hour++) {
                if (temps[day][hour] > maxTemp) {
                    maxTemp = temps[day][hour];
                    hottestDay = day;
                }
                if (temps[day][hour] < minTemp) {
                    minTemp = temps[day][hour];
                    coldestDay = day;
                }
            }
        }

        System.out.println("Hottest Day: Day " + (hottestDay + 1) + " with temperature " + maxTemp);
        System.out.println("Coldest Day: Day " + (coldestDay + 1) + " with temperature " + minTemp);
    }
    // Method to calculate average temperature per day
    public static void calculateAverageTemperaturePerDay(float[][] temps) {
        for (int day = 0; day < temps.length; day++) {
            float sum = 0;
            for (int hour = 0; hour < temps[day].length; hour++) {
                sum += temps[day][hour];
            }
            float average = sum / temps[day].length;
            System.out.printf("Average temperature for Day %d: %.2f%n", (day + 1), average);
        }
    }
}