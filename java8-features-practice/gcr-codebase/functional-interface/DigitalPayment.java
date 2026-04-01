interface Payment{
    void pay();
}

class Upi implements Payment{
    @Override
    public void pay(){
        System.out.println("Paying using UPI.");
    }
}

class CreditCard implements Payment{
    @Override
    public void pay(){
        System.out.println("Paying using Credit Card.");
    }
}

class Wallet implements Payment{
    @Override
    public void pay(){
        System.out.println("Paying using Wallet.");
    }
}

public class DigitalPayment {
    public static void main(String[] args){
        Payment upi = new Upi();
        Payment credit = new CreditCard();
        Payment wallet = new Wallet();

        upi.pay();
        credit.pay();
        wallet.pay();
    }
}
