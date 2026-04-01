import java.util.*;
class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    // Parameterized constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Public method to get balance
    public double getBalance() {
        return balance;
    }

    // Public method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Public method to withdraw amount
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}
class BankAccountTest {
    public static void main(String[] args) {
        // Creating a BankAccount object using parameterized constructor
        BankAccount account = new BankAccount("123456789", "Alice Johnson", 1000.0);
        
        // Displaying account details
        System.out.println("Bank Account Details:");
        account.displayDetails();
        
        // Performing deposit
        account.deposit(500.0);
        
        // Performing withdrawal
        account.withdraw(200.0);
        
        // Displaying updated account details
        System.out.println("Updated Bank Account Details:");
        account.displayDetails();
    }
}
