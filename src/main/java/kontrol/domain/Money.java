package kontrol.domain;

import java.util.Currency;
import java.util.Objects;

public final class Money {
    private final double amount;
    private final String currency;

    public Money (double amount){
        this(amount,"UAH");
    }

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0 && Objects.equals(currency, money.currency);
    }


}
