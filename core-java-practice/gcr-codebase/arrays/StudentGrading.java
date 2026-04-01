import java.util.Scanner;

public class StudentGrading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

    
        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

        
            System.out.print("Physics: ");
            physics[i] = sc.nextInt();
            while (physics[i] < 0) {
                System.out.print("Enter positive value for Physics: ");
                physics[i] = sc.nextInt();
            }

            System.out.print("Chemistry: ");
            chemistry[i] = sc.nextInt();
            while (chemistry[i] < 0) {
                System.out.print("Enter positive value for Chemistry: ");
                chemistry[i] = sc.nextInt();
            }
            System.out.print("Maths: ");
            maths[i] = sc.nextInt();
            while (maths[i] < 0) {
                System.out.print("Enter positive value for Maths: ");
                maths[i] = sc.nextInt();
            }

    
            int total = physics[i] + chemistry[i] + maths[i];
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
            System.out.println((i + 1) + "\t" + physics[i] + "\t" + chemistry[i] + "\t\t" + maths[i] + "\t" + percentage[i] + "\t\t" + grade[i]);
        }

        sc.close();
    }
}
