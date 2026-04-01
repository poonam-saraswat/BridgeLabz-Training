import java.util.*;

class WithdrawalRequest {
    private String accountNumber;
    private int amount;

    public WithdrawalRequest(String accountNumber, int amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAmount() {
        return amount;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // HashMap to store accounts (AccountNumber -> Balance)
        Map<String, Integer> accounts = new HashMap<>();

        System.out.print("Enter number of customers: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Input customer accounts
        for (int i = 0; i < n; i++) {
            System.out.print("Enter account number: ");
            String accNo = scanner.nextLine();

            System.out.print("Enter initial balance: ");
            int balance = scanner.nextInt();
            scanner.nextLine(); // consume newline

            accounts.put(accNo, balance);
        }

        // Queue for withdrawal requests
        Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

        System.out.print("\nEnter number of withdrawal requests: ");
        int m = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < m; i++) {
            System.out.print("Enter account number for withdrawal: ");
            String accNo = scanner.nextLine();

            System.out.print("Enter withdrawal amount: ");
            int amount = scanner.nextInt();
            scanner.nextLine(); // consume newline

            withdrawalQueue.add(new WithdrawalRequest(accNo, amount));
        }

        // Process withdrawal requests
        System.out.println("\nProcessing Withdrawal Requests...");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            String accNo = req.getAccountNumber();
            int amount = req.getAmount();

            if (accounts.containsKey(accNo)) {
                int currentBalance = accounts.get(accNo);
                if (currentBalance >= amount) {
                    accounts.put(accNo, currentBalance - amount);
                    System.out.println("Withdrawal of " + amount + " from Account " + accNo + " successful.");
                } else {
                    System.out.println("Insufficient balance in Account " + accNo);
                }
            } else {
                System.out.println("Account " + accNo + " not found.");
            }
        }

        // Display accounts sorted by balance using TreeMap
        TreeMap<Integer, List<String>> sortedByBalance = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : accounts.entrySet()) {
            String accNo = entry.getKey();
            Integer balance = entry.getValue();

            sortedByBalance.computeIfAbsent(balance, k -> new ArrayList<>()).add(accNo);
        }

        System.out.println("\nFinal Account Balances (Sorted by Balance):");
        for (Map.Entry<Integer, List<String>> entry : sortedByBalance.entrySet()) {
            System.out.println("Balance " + entry.getKey() + " -> Accounts " + entry.getValue());
        }

        scanner.close();
    }
}