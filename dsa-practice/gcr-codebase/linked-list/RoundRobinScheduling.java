// Node class representing each Process
class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

// Circular Linked List Round Robin Scheduler
class RoundRobinScheduler {
    private ProcessNode head = null;

    // Add process at the end
    public void addProcess(int id, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(id, burstTime, priority);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Remove process by ID
    public void removeProcess(int id) {
        if (head == null) return;

        ProcessNode temp = head, prev = null;
        do {
            if (temp.processId == id) {
                if (prev == null) { // removing head
                    ProcessNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    if (head == head.next) { // only one node
                        head = null;
                    } else {
                        last.next = head.next;
                        head = head.next;
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Process " + id + " completed and removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Display all processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        ProcessNode temp = head;
        do {
            System.out.println("[PID=" + temp.processId + ", Burst=" + temp.burstTime +
                    ", Remaining=" + temp.remainingTime + ", Priority=" + temp.priority + "]");
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate Round Robin Scheduling
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completedProcesses = 0;
        int currentTime = 0;

        ProcessNode current = head;
        while (head != null) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= execTime;
                currentTime += execTime;

                System.out.println("\nExecuting Process " + current.processId +
                        " for " + execTime + " units. Remaining: " + current.remainingTime);

                if (current.remainingTime == 0) {
                    int turnaroundTime = currentTime;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalTurnaroundTime += turnaroundTime;
                    totalWaitingTime += waitingTime;
                    completedProcesses++;

                    removeProcess(current.processId);
                    if (head == null) break;
                }
            }
            current = current.next;
            System.out.println("Processes after this round:");
            displayProcesses();
        }

        double avgWaitingTime = (double) totalWaitingTime / completedProcesses;
        double avgTurnaroundTime = (double) totalTurnaroundTime / completedProcesses;

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}

// Driver class
public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        System.out.println("Initial Processes:");
        scheduler.displayProcesses();

        int timeQuantum = 3;
        System.out.println("\nStarting Round Robin Scheduling with Time Quantum = " + timeQuantum);
        scheduler.simulate(timeQuantum);
    }
}
