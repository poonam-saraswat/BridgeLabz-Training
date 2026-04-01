import java.util.Scanner;

// Stage node for singly linked list
class Stage {
    String name;       // Stage name (Packed, Shipped, etc.)
    Stage next;        // Pointer to next stage

    Stage(String name) {
        this.name = name;
        this.next = null;
    }
}

// ParcelTracker class to manage delivery chain
class ParcelTracker {
    private Stage head;   // First stage in the chain

    // Initialize with default stages
    public ParcelTracker() {
        head = new Stage("Packed");
        Stage shipped = new Stage("Shipped");
        Stage transit = new Stage("In Transit");
        Stage delivered = new Stage("Delivered");

        // Linking stages
        head.next = shipped;
        shipped.next = transit;
        transit.next = delivered;
    }

    // Display all stages forward
    public void displayStages() {
        Stage current = head;
        while (current != null) {
            System.out.print(current.name);
            if (current.next != null) System.out.print(" → ");
            current = current.next;
        }
        System.out.println();
    }

    // Add custom checkpoint after a given stage
    public void addCheckpoint(String afterStage, String newStage) {
        Stage current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(afterStage)) {
                Stage checkpoint = new Stage(newStage);
                checkpoint.next = current.next;
                current.next = checkpoint;
                System.out.println("Checkpoint '" + newStage + "' added after '" + afterStage + "'");
                return;
            }
            current = current.next;
        }
        System.out.println("Stage '" + afterStage + "' not found!");
    }

    // Handle lost/missing parcel (simulate null pointer)
    public void markLost(String stageName) {
        Stage current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(stageName)) {
                current.next = null;  // Breaking the chain
                System.out.println("Parcel lost at stage: " + stageName);
                return;
            }
            current = current.next;
        }
        System.out.println("Stage '" + stageName + "' not found!");
    }
}

// Demo class with user input
public class ParcelTrackerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParcelTracker tracker = new ParcelTracker();

        int choice;
        do {
            System.out.println("\n--- Parcel Tracker Menu ---");
            System.out.println("1. Display Delivery Chain");
            System.out.println("2. Add Custom Checkpoint");
            System.out.println("3. Mark Parcel Lost");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    tracker.displayStages();
                    break;
                case 2:
                    System.out.print("Enter stage after which to add checkpoint: ");
                    String afterStage = sc.nextLine();
                    System.out.print("Enter new checkpoint name: ");
                    String newStage = sc.nextLine();
                    tracker.addCheckpoint(afterStage, newStage);
                    break;
                case 3:
                    System.out.print("Enter stage where parcel is lost: ");
                    String lostStage = sc.nextLine();
                    tracker.markLost(lostStage);
                    break;
                case 4:
                    System.out.println("Exiting Parcel Tracker...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}