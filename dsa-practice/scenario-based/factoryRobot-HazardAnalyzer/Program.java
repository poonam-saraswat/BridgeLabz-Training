import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        RobotHazardAuditor auditor = new RobotHazardAuditor();

        System.out.println("Enter the Arm Precision (0.0 - 1.0):");
        double armPrecision = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the Worker Density (1 - 20): ");
        int workerDensity = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineryState = sc.nextLine();

        try{
            auditor.isValidArmPrecision(armPrecision);
            auditor.isValidWorkerDensity(workerDensity);
            auditor.isValidMachineryState(machineryState);

            double hazardRisk = auditor.CalculateHazardRisk(armPrecision, workerDensity, machineryState);
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        }
        catch(RobotSafetyException e){
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
