public class BankingSystem extends Thread{
    private int balance = 10000;

    public synchronized boolean withdraw(String name, int amount){
        if(balance >= amount){
            try{
                Thread.sleep(200);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println("Transaction successful: " + name +  ", Amount: " + amount + ", Balance: " + balance);
            return true;
        }
        else{
            System.out.println("Transaction failed: " + name +  ", Amount: " + amount + ", Balance: " + balance);
            return false;
        }
    }

    public int getBalance(){
        return balance;
    }

    public static void main(String[] args) throws InterruptedException{
        BankingSystem account = new BankingSystem();

        Thread t1 = new Thread(new Transaction(account, "Alice", 2000), "Alice");
        Thread t2 = new Thread(new Transaction(account, "Bob", 4000), "Bob");

        t1.start();
        t2.start();
    }
}

class Transaction implements Runnable{
    private BankingSystem account;
    private String name;
    private int amount;

    public Transaction(BankingSystem account, String name, int amount){
        this.account = account;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void run(){
        System.out.println("[" + Thread.currentThread().getName() + "] Attempting to withdraw " + amount);
        account.withdraw(name, amount);
    }
}

