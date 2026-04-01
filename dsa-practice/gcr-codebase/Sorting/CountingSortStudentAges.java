import java.util.Scanner;

public class CountingSortStudentAges {

    // Counting Sort method
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;

        // Step 1: Create count array
        int[] count = new int[range];

        // Step 2: Store frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 3: Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 4: Place elements in output array
        int[] output = new int[ages.length];
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Step 5: Copy sorted output back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int age : arr) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];

        // Take student ages as input
        System.out.println("Enter " + n + " student ages (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        System.out.println("\nUnsorted Student Ages:");
        printArray(ages);

        // Apply Counting Sort
        countingSort(ages, 10, 18);

        System.out.println("Sorted Student Ages (Ascending):");
        printArray(ages);

        sc.close();
    }
}