import java.util.Scanner;

// Step 1: Define custom checked exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Step 2: BankAccount class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // withdraw method with exception handling
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            // IllegalArgumentException is unchecked, thrown directly
            throw new IllegalArgumentException("Invalid amount!");
        } else if (amount > balance) {
            // Custom checked exception
            throw new InsufficientBalanceException("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful, new balance: " + balance);
        }
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 3: Create account with initial balance
        BankAccount account = new BankAccount(1000.0);

        try {
            // Step 4: Take withdrawal amount
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();

            // Step 5: Attempt withdrawal
            account.withdraw(amount);

        } catch (InsufficientBalanceException e) {
            // Handle custom checked exception
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            // Handle invalid amount
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}