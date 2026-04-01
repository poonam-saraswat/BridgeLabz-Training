class PrintJob implements Runnable {

    private String jobName;
    private int pages;

    public PrintJob(String jobName, int pages) {
        this.jobName = jobName;
        this.pages = pages;
    }

    @Override
    public void run() {
        String priorityLabel;

        int p = Thread.currentThread().getPriority();
        if (p >= 8) priorityLabel = "High Priority";
        else if (p >= 6) priorityLabel = "Medium Priority";
        else priorityLabel = "Low Priority";

        for (int i = 1; i <= pages; i++) {
            System.out.println(
                    "[" + priorityLabel + "] Printing " +
                    jobName + " - Page " + i + " of " + pages
            );

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(jobName + " interrupted");
            }
        }
    }
}

public class PrintShop {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting print jobs...");

        long startTime = System.currentTimeMillis();

        Thread j1 = new Thread(new PrintJob("Job1", 10));
        Thread j2 = new Thread(new PrintJob("Job2", 5));
        Thread j3 = new Thread(new PrintJob("Job3", 15));
    

        j1.setPriority(5);
        j2.setPriority(8);
        j3.setPriority(3);

        j1.start();
        j2.start();
        j3.start();


        j1.join();
        j2.join();
        j3.join();
   
        long endTime = System.currentTimeMillis();

        System.out.println("All jobs completed in " + (endTime - startTime) + "ms");
    }
}


