import java.util.Scanner;

public class BubbleSortStudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Create array to store marks
        int[] marks = new int[n];

        // Input marks from user
        System.out.println("Enter the marks of " + n + " students:");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        System.out.println("\nOriginal Marks:");
        printArray(marks);

        // Perform Bubble Sort
        bubbleSort(marks);

        System.out.println("\nSorted Marks (Ascending Order):");
        printArray(marks);

        sc.close();
    }

    // Bubble Sort method
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Stop early if already sorted
            if (!swapped) break;
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int mark : arr) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}