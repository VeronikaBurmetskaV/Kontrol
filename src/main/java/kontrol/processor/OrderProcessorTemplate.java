package kontrol.processor;

import kontrol.domain.Money;
import kontrol.domain.Order;
import kontrol.domain.OrderItem;
import kontrol.exception.AppException;
import kontrol.exception.ArchiveOperationException;
import kontrol.exception.ValidException;
import kontrol.payment.PaymentMethod;
import kontrol.exception.PayException;

public abstract class OrderProcessorTemplate {
    private final PaymentMethod paymentMethod;

    protected OrderProcessorTemplate(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public final void process(Order order) throws AppException {
        try {
            System.out.println("Starting process for order " + order.getId());
            validate(order);
            double total = calculate(order);
            pay(new Money(total));
            order.setStatus("PAID");

            complete(order);
            archiveAfterDelivery(order);

            System.out.println("Order " + order.getId() + " processed successfully");
        }
        catch (PayException e) {
            System.out.println("Payment failed: " + e.getMessage());
            throw new AppException("Order processing failed", e);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }

    private void validate(Order order) throws ValidException {
        for (OrderItem item : order.getItems()) {
            if (item.getPrice() > 50000) {
                throw new ValidException("Item price 50000 limit");
            }
        }
    }

    protected double calculate(Order order) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            double price = item.getPrice();
            if ("CLEARANCE".equals(item.getCategory())) {
                price *= 0.8;
            }
            total += price;
        }
        return total;
    }

    private void pay(Money amount) throws PayException {
        paymentMethod.pay(amount.getAmount());
    }

    protected abstract void complete(Order order);

    protected void archiveAfterDelivery(Order order) throws ArchiveOperationException {
        if (!order.getStatus().equals("PAID")) throw new ArchiveOperationException("Wrong status");
        order.setStatus("SHIPPED");
        order.setStatus("DELIVERED");
        order.setStatus("ARCHIVED");
    }
}

