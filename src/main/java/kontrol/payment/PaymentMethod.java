package kontrol.payment;

import kontrol.exception.PayException;

public interface PaymentMethod {
    void pay(double amount) throws PayException;
}
