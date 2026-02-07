public class BackgroundJob {
    public static void main(String[] args){
        Runnable job = () ->{
            System.out.println("Job starting....");
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e){
                System.err.println("Interupption occured!");
            }

            System.out.println("Job finished!");
        };

        Thread thread = new Thread(job);
        thread.start();

        System.out.println("Main");
    }
}
