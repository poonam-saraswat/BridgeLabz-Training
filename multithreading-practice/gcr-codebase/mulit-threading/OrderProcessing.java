class Chef extends Thread{
    private String dish;
    private int duration;

    public Chef(String name, String dish, int duration){
        super(name);
        this.dish = dish;
        this.duration = duration;
    }

    @Override
    public void run(){
        System.out.println(getName() + " started preparing " + dish);

        try{
            int time = duration/4;

            for(int i = 25; i <= 100; i+=25){
                Thread.sleep(time);
                System.out.println(getName() + " preparing " + dish + ": " + i + "% complete.");
            }
        }
        catch(InterruptedException e){
            System.out.println(getName() + " interrupted ");
        }
    }
}

public class OrderProcessing{
    public static void main(String[] args) throws InterruptedException{
        Chef c1 = new Chef("Chef-1", "Pizza", 5000);
        Chef c2 = new Chef("Chef-2", "Pasta", 2000);
        Chef c3 = new Chef("Chef-3", "Salad", 3000);
        
        c1.start();
        c2.start();
        c3.start();

        c1.join();
        c2.join();
        c3.join();

        System.out.println("Kitchen closed - All orders completed.");
    }
}