import java.util.Random;
public class MatrixManipulation {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;

        int[][] matrixA = createRandomMatrix(rows, cols);
        int[][] matrixB = createRandomMatrix(rows, cols);

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        int[][] sumMatrix = addMatrices(matrixA, matrixB);
        System.out.println("Sum of Matrix A and B:");
        printMatrix(sumMatrix);

        int[][] diffMatrix = subtractMatrices(matrixA, matrixB);
        System.out.println("Difference of Matrix A and B:");
        printMatrix(diffMatrix);

        int[][] productMatrix = multiplyMatrices(matrixA, matrixB);
        System.out.println("Product of Matrix A and B:");
        printMatrix(productMatrix);
    }

    // Method to create a random matrix
    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // Random numbers between 0-9
            }
        }
        return matrix;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] diff = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                diff[i][j] = a[i][j] - b[i][j];
            }
        }
        return diff;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        int[][] product = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                product[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    product[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return product;
    }
}