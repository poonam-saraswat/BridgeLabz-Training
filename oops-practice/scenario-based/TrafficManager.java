import java.util.*;

// Vehicle node for Circular Linked List
class Vehicle {
    String vehicleId;
    Vehicle next;

    public Vehicle(String vehicleId) {
        this.vehicleId = vehicleId;
        this.next = null;
    }
}

// Circular Linked List for Roundabout
class Roundabout {
    private Vehicle head = null;

    // Add vehicle to roundabout
    public void addVehicle(String vehicleId) {
        Vehicle newVehicle = new Vehicle(vehicleId);
        if (head == null) {
            head = newVehicle;
            head.next = head; // circular link
        } else {
            Vehicle temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newVehicle;
            newVehicle.next = head;
        }
        System.out.println("🚗 Vehicle " + vehicleId + " entered the roundabout.");
    }

    // Remove vehicle from roundabout
    public void removeVehicle(String vehicleId) {
        if (head == null) {
            System.out.println("❌ Roundabout is empty.");
            return;
        }

        Vehicle current = head, prev = null;
        do {
            if (current.vehicleId.equals(vehicleId)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    // Removing head
                    if (head.next == head) {
                        head = null; // only one vehicle
                    } else {
                        Vehicle temp = head;
                        while (temp.next != head) {
                            temp = temp.next;
                        }
                        temp.next = head.next;
                        head = head.next;
                    }
                }
                System.out.println("🚙 Vehicle " + vehicleId + " exited the roundabout.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("❌ Vehicle " + vehicleId + " not found in roundabout.");
    }

    // Print roundabout state
    public void printRoundabout() {
        if (head == null) {
            System.out.println("🔄 Roundabout is empty.");
            return;
        }
        System.out.print("🔄 Roundabout state: ");
        Vehicle temp = head;
        do {
            System.out.print(temp.vehicleId + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to " + head.vehicleId + ")");
    }
}

// Queue for waiting vehicles
class VehicleQueue {
    private int maxSize;
    private Queue<String> queue;

    public VehicleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new LinkedList<>();
    }

    // Add vehicle to queue
    public void enqueue(String vehicleId) {
        if (queue.size() >= maxSize) {
            System.out.println("⚠️ Queue overflow! Vehicle " + vehicleId + " cannot wait.");
        } else {
            queue.add(vehicleId);
            System.out.println("⏳ Vehicle " + vehicleId + " is waiting in queue.");
        }
    }

    // Remove vehicle from queue
    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("⚠️ Queue underflow! No vehicles waiting.");
            return null;
        }
        return queue.poll();
    }

    // Print queue state
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("⏳ Queue is empty.");
        } else {
            System.out.println("⏳ Queue state: " + queue);
        }
    }
}

// Traffic Manager
public class TrafficManager {
    public static void main(String[] args) {
        Roundabout roundabout = new Roundabout();
        VehicleQueue waitingQueue = new VehicleQueue(3); // max 3 waiting vehicles

        // Vehicles arrive
        waitingQueue.enqueue("Car1");
        waitingQueue.enqueue("Car2");
        waitingQueue.enqueue("Car3");
        waitingQueue.enqueue("Car4"); // overflow

        waitingQueue.printQueue();

        // Move vehicles from queue to roundabout
        String v;
        while ((v = waitingQueue.dequeue()) != null) {
            roundabout.addVehicle(v);
        }

        roundabout.printRoundabout();

        // Remove a vehicle
        roundabout.removeVehicle("Car2");
        roundabout.printRoundabout();

        // Try removing non-existent vehicle
        roundabout.removeVehicle("Car5");

        // Final state
        roundabout.printRoundabout();
    }
}