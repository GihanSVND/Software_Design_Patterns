public class FactoryPattern {
    public static void main(String[] args){
        PaymentFactory paymentFactory = new PaymentFactory();

        Payment payment = paymentFactory.getPaymentMethod("Bank transfer");
        payment.pay(200);
    }

}

interface Payment {
    void pay(double amount);
}
class PaymentFactory {
    public Payment getPaymentMethod(String paymentType){
        if(paymentType.equalsIgnoreCase("Bank Transfer")){
            return new BankTransfer();
        } else if (paymentType.equalsIgnoreCase("Paypal")) {
            return new Paypal();
        } else {
            return new CreditCard();
        }
    }
}
class BankTransfer implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Processing the Bank Transfer :" + amount);
    }
}
class CreditCard implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit card Payment :" + amount);
    }
}
class Paypal implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Processing the Paypal Payment :" + amount);
    }
}


