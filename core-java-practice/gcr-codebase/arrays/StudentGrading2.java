
import java.util.Scanner;
public class StudentGrading2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3]; 
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");
            System.out.print("Physics: ");
            marks[i][0] = sc.nextInt();
            while (marks[i][0] < 0) {
                System.out.print("Enter positive value for Physics: ");
                marks[i][0] = sc.nextInt();
            }

            System.out.print("Chemistry: ");
            marks[i][1] = sc.nextInt();
            while (marks[i][1] < 0) {
                System.out.print("Enter positive value for Chemistry: ");
                marks[i][1] = sc.nextInt();
            }

            System.out.print("Maths: ");
            marks[i][2] = sc.nextInt();
            while (marks[i][2] < 0) {
                System.out.print("Enter positive value for Maths: ");
                marks[i][2] = sc.nextInt();
            }


            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

    
            if (percentage[i] >= 80) grade[i] = 'A';
            else if (percentage[i] >= 70) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else if (percentage[i] >= 50) grade[i] = 'D';
            else if (percentage[i] >= 40) grade[i] = 'E';
            else grade[i] = 'R';
        }

 
        System.out.println("\n--- Student Results ---");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + marks[i][0] + "\t" + marks[i][1] + "\t\t" + marks[i][2] + "\t" + percentage[i] + "\t\t" + grade[i]);
        }
    }
}