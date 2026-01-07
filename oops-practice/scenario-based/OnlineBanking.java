import java.util.*;

// Custom Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Transaction Record
class Transaction {
    private String type;
    private double amount;
    private Date date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return type + " of ₹" + amount + " on " + date;
    }
}

// Abstract Account
abstract class Account {
    protected int accountId;
    protected String owner;
    protected double balance;
    protected List<Transaction> history = new ArrayList<>();

    public Account(int accountId, String owner, double balance) {
        this.accountId = accountId;
        this.owner = owner;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        history.add(new Transaction("Deposit", amount));
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal!");
        }
        balance -= amount;
        history.add(new Transaction("Withdraw", amount));
    }

    public synchronized void transfer(Account toAccount, double amount) throws InsufficientBalanceException {
        this.withdraw(amount);
        toAccount.deposit(amount);
        history.add(new Transaction("Transfer to " + toAccount.owner, amount));
    }

    public double getBalance() { return balance; }

    public void printHistory() {
        System.out.println("Transaction history for " + owner + ":");
        for (Transaction t : history) {
            System.out.println(t);
        }
    }

    public abstract double calculateInterest();
}

// Savings Account
class SavingsAccount extends Account {
    private double interestRate = 0.04; // 4%

    public SavingsAccount(int id, String owner, double balance) {
        super(id, owner, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
}

// Current Account
class CurrentAccount extends Account {
    private double interestRate = 0.02; // 2%

    public CurrentAccount(int id, String owner, double balance) {
        super(id, owner, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
}

// Abstraction: BankService
interface BankService {
    Account createAccount(String type, int id, String owner, double balance);
    void showBalance(Account account);
    void showHistory(Account account);
}

// Implementation
class BankServiceImpl implements BankService {
    private Map<Integer, Account> accounts = new HashMap<>();

    @Override
    public Account createAccount(String type, int id, String owner, double balance) {
        Account acc;
        if (type.equalsIgnoreCase("savings")) {
            acc = new SavingsAccount(id, owner, balance);
        } else {
            acc = new CurrentAccount(id, owner, balance);
        }
        accounts.put(id, acc);
        return acc;
    }

    @Override
    public void showBalance(Account account) {
        System.out.println(account.owner + " balance: ₹" + account.getBalance());
    }

    @Override
    public void showHistory(Account account) {
        account.printHistory();
    }
}

// Test with Multithreading
public class OnlineBanking{
    public static void main(String[] args) {
        BankService bank = new BankServiceImpl();

        Account acc1 = bank.createAccount("savings", 101, "Alice", 5000);
        Account acc2 = bank.createAccount("current", 102, "Bob", 3000);

        Runnable task1 = () -> {
            try {
                acc1.transfer(acc2, 2000);
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        };

        Runnable task2 = () -> {
            try {
                acc2.transfer(acc1, 1000);
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bank.showBalance(acc1);
        bank.showBalance(acc2);

        bank.showHistory(acc1);
        bank.showHistory(acc2);

        System.out.println("Interest for Alice: ₹" + acc1.calculateInterest());
        System.out.println("Interest for Bob: ₹" + acc2.calculateInterest());
    }
}