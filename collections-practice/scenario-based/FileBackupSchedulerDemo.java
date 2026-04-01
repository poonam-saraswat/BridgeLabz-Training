import java.util.PriorityQueue;

// Custom Exception
class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

// BackupTask class implementing Comparable
class BackupTask implements Comparable<BackupTask> {
    private String folderPath;
    private int priority; // Higher number = higher priority
    private String scheduledTime;

    public BackupTask(String folderPath, int priority, String scheduledTime) throws InvalidBackupPathException {
        if (folderPath == null || folderPath.trim().isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path: " + folderPath);
        }
        this.folderPath = folderPath;
        this.priority = priority;
        this.scheduledTime = scheduledTime;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public int getPriority() {
        return priority;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    @Override
    public int compareTo(BackupTask other) {
        // Higher priority first; if equal, sort by scheduled time (lexicographically)
        int priorityComparison = Integer.compare(other.priority, this.priority);
        if (priorityComparison == 0) {
            return this.scheduledTime.compareTo(other.scheduledTime);
        }
        return priorityComparison;
    }

    @Override
    public String toString() {
        return "BackupTask{" +
                "folderPath='" + folderPath + '\'' +
                ", priority=" + priority +
                ", scheduledTime='" + scheduledTime + '\'' +
                '}';
    }
}

// Scheduler class
class BackupScheduler {
    private PriorityQueue<BackupTask> taskQueue = new PriorityQueue<>();

    // Add task
    public void scheduleBackup(String folderPath, int priority, String scheduledTime) {
        try {
            BackupTask task = new BackupTask(folderPath, priority, scheduledTime);
            taskQueue.add(task);
            System.out.println("Scheduled: " + task);
        } catch (InvalidBackupPathException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Execute tasks in priority order
    public void executeBackups() {
        System.out.println("\nExecuting backups in priority order:");
        while (!taskQueue.isEmpty()) {
            BackupTask task = taskQueue.poll();
            System.out.println("Executing backup: " + task);
            // Simulate backup logic here
        }
    }
}

// Demo
public class FileBackupSchedulerDemo {
    public static void main(String[] args) {
        BackupScheduler scheduler = new BackupScheduler();

        // Schedule backups
        scheduler.scheduleBackup("C:/CriticalData", 5, "08:00 AM");
        scheduler.scheduleBackup("D:/Movies", 1, "09:00 AM");
        scheduler.scheduleBackup("C:/Projects", 3, "07:30 AM");

        // Invalid path test
        scheduler.scheduleBackup("", 4, "10:00 AM");

        // Execute backups
        scheduler.executeBackups();
    }
}