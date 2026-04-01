import java.util.Map;
import java.util.Scanner;

public class StreamBuzz {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Program program = new Program();
        boolean b = true;

        while(b){
            displayMenu();
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter Creator Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter weekly likes(Week 1 to 4): ");
                    double[] likes = new double[4];
                    for(int i = 0; i < 4; i++){
                        likes[i] = sc.nextDouble();
                    }
                    program.RegisterCreator(new CreatorStats(name, likes));
                    System.out.println("Creator Registered Successfully");
                    break;

                case 2:
                    System.out.println("Enter Like threshold: ");
                    int threshold = sc.nextInt();
                    Map<String, Integer> map = program.GetTopPostCounts(threshold);
                    if(!map.isEmpty()){
                        for(Map.Entry<String, Integer> entry: map.entrySet()){
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    else{
                        System.out.println("No top-performing posts this week");
                    }
                    break;

                case 3:
                    double average = program.CalculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + average);
                    break;
                
                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    b = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }

    public static void displayMenu(){
        System.out.println("---------- Welcome to Stream Buzz ---------");
        System.out.println("1. Register Creator");
        System.out.println("2. Show Top Posts");
        System.out.println("3. Calculate Average Likes");
        System.out.println("4. Exit");
    }
}
