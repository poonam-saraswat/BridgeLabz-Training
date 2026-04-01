import java.util.Arrays;
public class AverageMaxMin {
    public static void main(String[] args) {
        int size = 5;
        int[] randomNumbers = generate4DigitRandomArray(size);
        System.out.println("Generated 4-digit random numbers: " + Arrays.toString(randomNumbers));

        double[] results = findAverageMinMax(randomNumbers);
        System.out.printf("Average: %.2f, Minimum: %.0f, Maximum: %.0f%n",
                results[0], results[1], results[2]);
    }

    // Method to generate an array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = 1000 + (int)(Math.random() * 9000); // Generates a number between 1000 and 9999
        }
        return randomNumbers;
    }

    // Method to find average, min, and max of an array
    public static double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            sum += number;
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        double average = (double) sum / numbers.length;
        return new double[]{average, min, max};
    }
}