import java.util.Scanner;
public class YoungestFriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Taking user input for ages and heights of the 3 friends
        for (int i = 0; i < friends.length; i++) {
            System.out.print("Enter age of " + friends[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height of " + friends[i] + " (in cm): ");
            heights[i] = scanner.nextDouble();
        }

        // Finding the youngest friend
        String youngestFriend = findYoungestFriend(friends, ages);
        System.out.println("The youngest friend is: " + youngestFriend);

        // Finding the tallest friend
        String tallestFriend = findTallestFriend(friends, heights);
        System.out.println("The tallest friend is: " + tallestFriend);

        scanner.close();
    }

    // Method to find the youngest friend
    public static String findYoungestFriend(String[] friends, int[] ages) {
        int minAgeIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minAgeIndex]) {
                minAgeIndex = i;
            }
        }
        return friends[minAgeIndex];
    }

    // Method to find the tallest friend
    public static String findTallestFriend(String[] friends, double[] heights) {
        int maxHeightIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }
        return friends[maxHeightIndex];
    }
}