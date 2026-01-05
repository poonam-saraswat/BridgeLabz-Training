// Interface for Loanable accounts
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class BankAccount
abstract class BankAccount implements Loanable {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Display details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
        System.out.println("-----------------------------------");
    }
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Application for: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000; // Eligible if balance >= 5000
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; // Flat 2% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Application for: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() + overdraftLimit >= 10000; // Eligible if balance + overdraft >= 10000
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SA101", "Alice", 8000, 0.04);
        BankAccount acc2 = new CurrentAccount("CA202", "Bob", 3000, 7000);

        BankAccount[] accounts = {acc1, acc2};

        // Polymorphism: process accounts dynamically
        for (BankAccount account : accounts) {
            account.deposit(2000);
            account.withdraw(1000);
            account.displayDetails();

            // Loanable interface methods
            account.applyForLoan(5000);
            System.out.println("Loan Eligibility: " + account.calculateLoanEligibility());
            System.out.println("-----------------------------------");
        }
    }
}
