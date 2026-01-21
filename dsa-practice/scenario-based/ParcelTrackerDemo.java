package dsa_practice;

// ParcelTracker.java
class ParcelStage {
    String stageName;
    ParcelStage next;  // pointer to next stage

    ParcelStage(String stageName) {
        this.stageName = stageName;
        this.next = null;
    }
}

class ParcelTracker {
    private ParcelStage head;  // starting stage

    // Initialize with default stages
    public ParcelTracker() {
        head = new ParcelStage("Packed");
        ParcelStage shipped = new ParcelStage("Shipped");
        ParcelStage inTransit = new ParcelStage("In Transit");
        ParcelStage delivered = new ParcelStage("Delivered");

        // Linking stages
        head.next = shipped;
        shipped.next = inTransit;
        inTransit.next = delivered;
    }

    // Add a custom checkpoint after a given stage
    public void addCheckpoint(String afterStage, String newStage) {
        ParcelStage current = head;
        while (current != null) {
            if (current.stageName.equals(afterStage)) {
                ParcelStage checkpoint = new ParcelStage(newStage);
                checkpoint.next = current.next;
                current.next = checkpoint;
                System.out.println("Checkpoint '" + newStage + "' added after '" + afterStage + "'");
                return;
            }
            current = current.next;
        }
        System.out.println("Stage '" + afterStage + "' not found.");
    }

    // Simulate parcel lost (set next pointer to null)
    public void markParcelLost(String stageName) {
        ParcelStage current = head;
        while (current != null) {
            if (current.stageName.equals(stageName)) {
                current.next = null;  // break the chain
                System.out.println("Parcel lost after stage: " + stageName);
                return;
            }
            current = current.next;
        }
        System.out.println("Stage '" + stageName + "' not found.");
    }

    // Track parcel forward through stages
    public void trackParcel() {
        ParcelStage current = head;
        while (current != null) {
            System.out.print(current.stageName);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class ParcelTrackerDemo {
    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();

        System.out.println("Initial Tracking:");
        tracker.trackParcel();

        System.out.println("\nAdding custom checkpoint:");
        tracker.addCheckpoint("In Transit", "At Warehouse");
        tracker.trackParcel();

        System.out.println("\nMarking parcel lost:");
        tracker.markParcelLost("At Warehouse");
        tracker.trackParcel();
    }
}