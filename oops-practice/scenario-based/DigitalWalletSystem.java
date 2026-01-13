import java.util.*;

// User class (Encapsulation)
class User {
    private String userId;
    private String name;
    private Wallet wallet;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.wallet = new Wallet(this);
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }
}

// Wallet class
class Wallet {
    private User owner;
    private double balance;
    private List<Transaction> transactions;

    public Wallet(User owner) {
        this.owner = owner;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction(owner.getName(), "Wallet", amount, "Credit"));
        System.out.println("✅ Added ₹" + amount + " to wallet. Current balance: ₹" + balance);
    }

    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance in wallet.");
        }
        balance -= amount;
        transactions.add(new Transaction(owner.getName(), "Wallet", amount, "Debit"));
        System.out.println("✅ Withdrawn ₹" + amount + " from wallet. Current balance: ₹" + balance);
    }

    public void recordTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void viewTransactions() {
        System.out.println("\n📋 Transaction History for " + owner.getName() + ":");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}

// Transaction class
class Transaction {
    private String from;
    private String to;
    private double amount;
    private String type; // Credit/Debit

    public Transaction(String from, String to, double amount, String type) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction [From=" + from + ", To=" + to + ", Amount=₹" + amount + ", Type=" + type + "]";
    }
}

// Custom Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Transfer Service Interface (Abstraction)
interface TransferService {
    void transfer(User fromUser, User toUser, double amount) throws InsufficientBalanceException;
}

// Wallet-to-Wallet Transfer (Polymorphism)
class WalletTransfer implements TransferService {
    @Override
    public void transfer(User fromUser, User toUser, double amount) throws InsufficientBalanceException {
        Wallet fromWallet = fromUser.getWallet();
        Wallet toWallet = toUser.getWallet();

        if (fromWallet.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance for transfer.");
        }

        fromWallet.withdrawMoney(amount);
        toWallet.addMoney(amount);

        Transaction transaction = new Transaction(fromUser.getName(), toUser.getName(), amount, "Wallet Transfer");
        fromWallet.recordTransaction(transaction);
        toWallet.recordTransaction(transaction);

        System.out.println("💸 Wallet transfer successful: " + fromUser.getName() + " → " + toUser.getName() + " (₹" + amount + ")");
    }
}

// Bank Transfer (Polymorphism)
class BankTransfer implements TransferService {
    @Override
    public void transfer(User fromUser, User toUser, double amount) throws InsufficientBalanceException {
        Wallet fromWallet = fromUser.getWallet();

        if (fromWallet.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance for bank transfer.");
        }

        fromWallet.withdrawMoney(amount);

        Transaction transaction = new Transaction(fromUser.getName(), "Bank Account of " + toUser.getName(), amount, "Bank Transfer");
        fromWallet.recordTransaction(transaction);

        System.out.println("🏦 Bank transfer successful: " + fromUser.getName() + " → Bank Account of " + toUser.getName() + " (₹" + amount + ")");
    }
}

// Main class to test
public class DigitalWalletSystem {
    public static void main(String[] args) {
        User u1 = new User("U101", "Poonam");
        User u2 = new User("U102", "Rahul");

        // Add money
        u1.getWallet().addMoney(5000);
        u2.getWallet().addMoney(2000);

        // Wallet transfer
        TransferService walletTransfer = new WalletTransfer();
        try {
            walletTransfer.transfer(u1, u2, 1500);
        } catch (InsufficientBalanceException e) {
            System.out.println("❌ Exception: " + e.getMessage());
        }

        // Bank transfer
        TransferService bankTransfer = new BankTransfer();
        try {
            bankTransfer.transfer(u2, u1, 1000);
        } catch (InsufficientBalanceException e) {
            System.out.println("❌ Exception: " + e.getMessage());
        }

        // View transactions
        u1.getWallet().viewTransactions();
        u2.getWallet().viewTransactions();
    }
}