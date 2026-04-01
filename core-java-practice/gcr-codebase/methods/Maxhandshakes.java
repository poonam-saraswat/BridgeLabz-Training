/*Create a program to find the maximum number of handshakes among students.
Hint => 
Get integer input for the numberOfStudents variable.
Use the combination = (n * (n - 1)) / 2 formula to calculate the maximum number of possible handshakes.
Write a method to use the combination formulae to calculate the number of handshakes
Display the number of possible handshakes.
 */
import java.util.Scanner;
public class Maxhandshakes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        int maxHandshakes = calculateMaxHandshakes(numberOfStudents);

        System.out.printf("The maximum number of handshakes among %d students is %d%n",
                numberOfStudents, maxHandshakes);

        scanner.close();
    }

    // Method to calculate maximum number of handshakes
    public static int calculateMaxHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}