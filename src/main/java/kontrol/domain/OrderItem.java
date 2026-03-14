package kontrol.domain;

public class OrderItem {
    public final String name;
    public final double price;
    private final String category;
    public OrderItem (String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }



    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
}
