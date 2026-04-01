import java.util.*;

class Patient {
    String name;
    int severity; // higher value = more severe

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // PriorityQueue with custom comparator (higher severity first)
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.severity, p1.severity)
        );

        // Input number of patients
        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input patient details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Patient " + (i+1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Severity (integer, higher = more severe): ");
            int severity = sc.nextInt();
            sc.nextLine(); // consume newline

            triageQueue.add(new Patient(name, severity));
        }

        // Treat patients in order of severity
        System.out.println("\n--- Treatment Order ---");
        while (!triageQueue.isEmpty()) {
            Patient p = triageQueue.poll();
            System.out.println("Treating: " + p);
        }

        sc.close();
    }
}