package kontrol.payment;

public class BankTransferPayment implements PaymentMethod{
    @Override
    public void pay (double amount) {
        double total = amount*1.01;
    }
}
