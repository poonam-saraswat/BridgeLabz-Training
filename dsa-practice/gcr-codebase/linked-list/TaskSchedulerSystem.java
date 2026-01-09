// Node class representing each Task
class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Circular Linked List Task Scheduler
class TaskScheduler {
    private TaskNode head = null;
    private TaskNode current = null;

    // Add task at the beginning
    public void addTaskAtBeginning(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    // Add task at the end
    public void addTaskAtEnd(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Add task at a specific position (1-based index)
    public void addTaskAtPosition(int id, String name, int priority, String dueDate, int position) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (position == 1) {
            addTaskAtBeginning(id, name, priority, dueDate);
            return;
        }
        TaskNode temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove task by Task ID
    public void removeTaskById(int id) {
        if (head == null) return;

        TaskNode temp = head, prev = null;
        do {
            if (temp.taskId == id) {
                if (prev == null) { // removing head
                    TaskNode last = head;
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
                System.out.println("Task with ID " + id + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + id + " not found.");
    }

    // View current task
    public void viewCurrentTask() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            System.out.println("Current Task: [ID=" + current.taskId + ", Name=" + current.taskName +
                    ", Priority=" + current.priority + ", DueDate=" + current.dueDate + "]");
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Move to next task
    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
            viewCurrentTask();
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        TaskNode temp = head;
        do {
            System.out.println("[ID=" + temp.taskId + ", Name=" + temp.taskName +
                    ", Priority=" + temp.priority + ", DueDate=" + temp.dueDate + "]");
            temp = temp.next;
        } while (temp != head);
    }

    // Search task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: [ID=" + temp.taskId + ", Name=" + temp.taskName +
                        ", Priority=" + temp.priority + ", DueDate=" + temp.dueDate + "]");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with Priority " + priority);
        }
    }
}

// Driver class
public class TaskSchedulerSystem{
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTaskAtEnd(1, "Design Module", 2, "2026-01-15");
        scheduler.addTaskAtEnd(2, "Write Documentation", 1, "2026-01-20");
        scheduler.addTaskAtBeginning(3, "Setup Environment", 3, "2026-01-10");
        scheduler.addTaskAtPosition(4, "Code Review", 2, "2026-01-18", 2);

        System.out.println("\nAll Tasks:");
        scheduler.displayAllTasks();

        System.out.println("\nViewing Current Task:");
        scheduler.viewCurrentTask();

        System.out.println("\nMoving to Next Task:");
        scheduler.moveToNextTask();

        System.out.println("\nSearching by Priority (2):");
        scheduler.searchTaskByPriority(2);

        System.out.println("\nRemoving Task with ID 2:");
        scheduler.removeTaskById(2);

        System.out.println("\nAll Tasks After Removal:");
        scheduler.displayAllTasks();
    }
}
