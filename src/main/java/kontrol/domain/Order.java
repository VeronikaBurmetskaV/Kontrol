package kontrol.domain;

public class Order {
    private final String id;
    private final OrderItem[]  items;
    private String status;
    public Order(String id, OrderItem[] items) {
        this.id = id;
        this.items = items;
        this.status = "NEW";
    }

    public String getId() {
        return id;
    }
    public OrderItem[] getItems() {
        return items;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}



