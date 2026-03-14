package kontrol.payment;

import kontrol.exception.PayException;

public class CardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) throws PayException {
        if (amount > 20000) {
            throw new PayException("Card limit reached");
        }
    }
}
