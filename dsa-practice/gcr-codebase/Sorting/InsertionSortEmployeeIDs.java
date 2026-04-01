import java.util.Scanner;

public class InsertionSortEmployeeIDs {

    // Method to perform insertion sort
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;

        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];   // Current element
            int j = i - 1;

            // Shift elements greater than key to one position ahead
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key;
        }
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int id : arr) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of employees
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] employeeIDs = new int[n];

        // Take employee IDs as input
        System.out.println("Enter " + n + " employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIDs[i] = sc.nextInt();
        }

        System.out.println("\nUnsorted Employee IDs:");
        printArray(employeeIDs);

        // Sort using insertion sort
        insertionSort(employeeIDs);

        System.out.println("Sorted Employee IDs (Ascending):");
        printArray(employeeIDs);

        sc.close();
    }
}