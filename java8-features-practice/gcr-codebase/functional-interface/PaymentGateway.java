interface Payment {
    void processPayment(double amount);
    default void refund(double amount) {
        System.out.println("Refund initiated.");
    }
}

class Paytm implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via Paytm");
    }
}

class Stripe implements Payment{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via Stripe");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding via Stripe");
    }
}


public class PaymentGateway {
    public static void main(String[] args){
        Payment paytm = new Paytm();
        Payment stripe = new Stripe();

        paytm.refund(500); 
        stripe.refund(500); 
    }
}
