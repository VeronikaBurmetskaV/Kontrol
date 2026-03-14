package kontrol.payment;

import kontrol.domain.Money;
import kontrol.exception.PayException;

public class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) throws PayException {
        if (amount < 100) {
            throw new PayException("Amount must be greater than 100");
        }
    }
}
