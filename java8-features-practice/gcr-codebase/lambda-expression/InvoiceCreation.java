import java.util.*;

class Invoice {
    int transactionId;

    Invoice(int transactionId) {
        this.transactionId = transactionId;
    }
}

public class InvoiceCreation {
   public static void main(String[] args) {

        List<Integer> transactions = List.of(1001, 1002, 1003);

        List<Invoice> invoices = transactions.stream().map(Invoice::new).toList();

        System.out.println(invoices.size());
    }  
}
