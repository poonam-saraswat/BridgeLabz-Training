class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountType() {
        System.out.println("This is a generic bank account.");
    }
}
class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType() {
        System.out.println("This is a Savings Account with interest rate: " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountType() {
        System.out.println("This is a Checking Account with withdrawal limit: $" + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount {
    double interestRate;
    int duration; // in months

    public FixedDepositAccount(String accountNumber, double balance, double interestRate, int duration) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
        this.duration = duration;
    }

    @Override
    public void displayAccountType() {
        System.out.println("This is a Fixed Deposit Account with interest rate: " + interestRate + "% and duration: " + duration + " months");
    }
}
public class BankAccountTypes {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 5000.0, 3.5);
        CheckingAccount checking = new CheckingAccount("CA123", 2000.0, 1000.0);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FDA123", 10000.0, 5.0, 12);

        savings.displayAccountType();
        checking.displayAccountType();
        fixedDeposit.displayAccountType();
    }
}
