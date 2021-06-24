package homeworks.basic_tasks.collections;

import java.time.Month;

public class ProductInstance {
    private Month month;
    private String name;
    private double price;

    ProductInstance (String name, Month month, int price) {
        this.name = name;
        this.month = month;
        this.price = price;
    }

    public Month getMonth() {
        return month;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
