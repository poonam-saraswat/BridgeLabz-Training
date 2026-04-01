import java.io.*;
import java.util.Scanner;

public class StudentDataStreamExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "students.dat";

        // Step 1: Write student details into binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            System.out.print("Enter number of students: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Student " + (i + 1));

                System.out.print("Roll Number: ");
                int roll = Integer.parseInt(sc.nextLine());

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("GPA: ");
                double gpa = Double.parseDouble(sc.nextLine());

                // Writing data in binary format
                dos.writeInt(roll);
                dos.writeUTF(name);
                dos.writeDouble(gpa);
            }
            System.out.println("\nStudent details successfully written to " + filename);
        } catch (IOException e) {
            System.out.println("IOException during writing: " + e.getMessage());
        }

        // Step 2: Read student details back from binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("\nRetrieved Student Details:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("IOException during reading: " + e.getMessage());
        }

        sc.close();
    }
}