import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vessels to be added: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("\nEnter Vessel details: ");
        String[] input = new String[n];
        for(int i = 0; i < n; i++){
            input[i] = sc.nextLine();
        }

        VesselUtil util = new VesselUtil();
        for(int i = 0; i < n; i++){
            String[] details = input[i].split(":");
            util.addVesselPerformance(new Vessel(details[0], details[1], Double.parseDouble(details[2]), details[3]));
        }

        System.out.println("\nEnter the Vessel Id to check speed: ");
        String id = sc.nextLine();
        Vessel v = util.getVesselById(id);
        if(v == null) System.out.println("Vessel Id " + id + " not found.");
        else System.out.println(v);

        System.out.println("\nHight performance vessels are: ");
        List<Vessel> result = util.getHighPerformanceVessels();
        for(Vessel v1 : result){
            System.out.println(v1);
        }

        sc.close();
    }
}
