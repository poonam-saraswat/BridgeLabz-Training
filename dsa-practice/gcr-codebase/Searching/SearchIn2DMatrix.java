import java.util.Scanner;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        // Step 2: Input matrix elements
        System.out.println("Enter the elements of the matrix (sorted as per problem statement):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Step 3: Input target value
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        // Step 4: Perform binary search
        boolean found = searchMatrix(matrix, rows, cols, target);

        // Step 5: Output result
        if (found) {
            System.out.println("Target " + target + " found in the matrix.");
        } else {
            System.out.println("Target " + target + " not found in the matrix.");
        }

        scanner.close();
    }

    // Method to perform binary search in 2D matrix
    public static boolean searchMatrix(int[][] matrix, int rows, int cols, int target) {
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Convert mid to row and column indices
            int row = mid / cols;
            int col = mid % cols;

            int midValue = matrix[row][col];

            if (midValue == target) {
                return true; // target found
            } else if (midValue < target) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        return false; // target not found
    }
}