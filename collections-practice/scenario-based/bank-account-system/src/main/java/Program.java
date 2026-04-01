public class Program{
    private double balance;

    public Program(double balance){
        this.balance = balance;
    }

    public double getBalance(){ return balance; }

    public void depositAmount(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Deposit amount cannot be negative.");
        }

        balance += amount;
        System.out.println("Amount deposited successfully!");
    }

    public void withdrawAmount(double amount){
        if(balance < amount){
            throw new IllegalArgumentException("Insufficient Funds!");
        }

        balance -= amount;
        System.out.println("Amount withdrawn successfully");
    }
}