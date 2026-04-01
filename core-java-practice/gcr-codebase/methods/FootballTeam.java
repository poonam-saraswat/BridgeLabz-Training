import java.util.Arrays;
public class FootballTeam {
    public static void main(String[] args) {
        int teamSize = 11;
        int[] heights = generateRandomHeights(teamSize);

        System.out.println("Heights of players (in cm): " + Arrays.toString(heights));

        int sumOfHeights = calculateSum(heights);
        double meanHeight = calculateMean(heights);
        int shortestHeight = findShortestHeight(heights);
        int tallestHeight = findTallestHeight(heights);

        System.out.println("Sum of heights: " + sumOfHeights + " cm");
        System.out.printf("Mean height: %.2f cm%n", meanHeight);
        System.out.println("Shortest height: " + shortestHeight + " cm");
        System.out.println("Tallest height: " + tallestHeight + " cm");
    }

    // Method to generate random heights between 150 cm and 250 cm
    public static int[] generateRandomHeights(int size) {
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = 150 + (int)(Math.random() * 101); // Generates a number between 150 and 250
        }
        return heights;
    }

    // Method to calculate the sum of heights
    public static int calculateSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    // Method to calculate the mean height
    public static double calculateMean(int[] heights) {
        return (double) calculateSum(heights) / heights.length;
    }

    // Method to find the shortest height
    public static int findShortestHeight(int[] heights) {
        int minHeight = Integer.MAX_VALUE;
        for (int height : heights) {
            if (height < minHeight) {
                minHeight = height;
            }
        }
        return minHeight;
    }

    // Method to find the tallest height
    public static int findTallestHeight(int[] heights) {
        int maxHeight = Integer.MIN_VALUE;
        for (int height : heights) {
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return maxHeight;
    }
}