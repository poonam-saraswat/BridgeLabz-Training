import java.util.*;

// Vehicle node for circular linked list
class Vehicle {
    String number;   // Vehicle number/ID
    Vehicle next;    // Next vehicle in roundabout

    Vehicle(String number) {
        this.number = number;
        this.next = null;
    }
}

// Roundabout class using Circular Linked List
class Roundabout {
    private Vehicle head = null;

    // Add vehicle to roundabout
    public void addVehicle(String number) {
        Vehicle newVehicle = new Vehicle(number);
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
        System.out.println("Vehicle " + number + " entered the roundabout.");
    }

    // Remove vehicle from roundabout
    public void removeVehicle(String number) {
        if (head == null) {
            System.out.println("Roundabout is empty!");
            return;
        }

        Vehicle current = head, prev = null;
        do {
            if (current.number.equals(number)) {
                if (prev == null) { // removing head
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
                } else {
                    prev.next = current.next;
                }
                System.out.println("Vehicle " + number + " exited the roundabout.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Vehicle " + number + " not found in roundabout.");
    }

    // Print roundabout state
    public void printRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }
        System.out.print("Roundabout Vehicles: ");
        Vehicle temp = head;
        do {
            System.out.print(temp.number + " → ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to " + head.number + ")");
    }
}

// TrafficManager Demo
public class TrafficManagerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Roundabout roundabout = new Roundabout();
        Queue<String> waitingQueue = new LinkedList<>();
        int maxQueueSize = 5; // Example capacity

        int choice;
        do {
            System.out.println("\n--- TrafficManager Menu ---");
            System.out.println("1. Add Vehicle to Waiting Queue");
            System.out.println("2. Move Vehicle from Queue to Roundabout");
            System.out.println("3. Remove Vehicle from Roundabout");
            System.out.println("4. Print Roundabout State");
            System.out.println("5. Print Waiting Queue");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (waitingQueue.size() >= maxQueueSize) {
                        System.out.println("Queue Overflow! Cannot add more vehicles.");
                    } else {
                        System.out.print("Enter Vehicle Number: ");
                        String num = sc.nextLine();
                        waitingQueue.add(num);
                        System.out.println("Vehicle " + num + " added to waiting queue.");
                    }
                    break;
                case 2:
                    if (waitingQueue.isEmpty()) {
                        System.out.println("Queue Underflow! No vehicles waiting.");
                    } else {
                        String num = waitingQueue.poll();
                        roundabout.addVehicle(num);
                    }
                    break;
                case 3:
                    System.out.print("Enter Vehicle Number to remove: ");
                    String num = sc.nextLine();
                    roundabout.removeVehicle(num);
                    break;
                case 4:
                    roundabout.printRoundabout();
                    break;
                case 5:
                    System.out.println("Waiting Queue: " + waitingQueue);
                    break;
                case 6:
                    System.out.println("Exiting TrafficManager...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}