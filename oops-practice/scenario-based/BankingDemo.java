// Abstract base class
abstract class BankAccount {
    // Immutable core data
    private final String accountNumber;
    private final double balance;

    // Constructor ensures immutability of accountNumber and balance
    public BankAccount(String accountNumber, double balance) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        if (balance < 0.0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter methods to access immutable fields
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Abstract method for polymorphic fee calculation
    public abstract double calculateFee();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        // Fee = 0.5% of balance
        return getBalance() * 0.005;
    }
}

// CheckingAccount subclass
class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        // Fee = flat 1.0 if balance < 1000, otherwise 0.0
        return getBalance() < 1000.0 ? 1.0 : 0.0;
    }
}

// Demo class with test cases
public class BankingDemo {
    public static void main(String[] args) {
        // Sample Input
        BankAccount savings = new SavingsAccount("12345", 1000.0);
        System.out.printf("%.2f%n", savings.calculateFee()); // Expected Output: 5.00

        // Test Cases
        BankAccount savings2 = new SavingsAccount("67890", 500.0);
        System.out.printf("%.2f%n", savings2.calculateFee()); // Expected Output: 2.50

        BankAccount checking1 = new CheckingAccount("11111", 1500.0);
        System.out.printf("%.2f%n", checking1.calculateFee()); // Expected Output: 0.00

        BankAccount checking2 = new CheckingAccount("22222", 500.0);
        System.out.printf("%.2f%n", checking2.calculateFee()); // Expected Output: 1.00
    }
}