package homeworks.simple_internet_shop;

import java.util.LinkedList;
import java.util.List;

public class Product {

    // create new product
    // set  and add companionProducts to product
    // change qty value


    private String typeName;
    private String modelName;
    private String brandName;
    private int year;
    private double price;
    private int qty;
    private List<Product> companionProducts;

    public Product(String typeName, String modelName, String brandName, int year, double price, int qty) {
        this.typeName = typeName;
        this.modelName = modelName;
        this.brandName = brandName;
        this.year = year;
        this.price = price;
        this.qty = qty;
        companionProducts = new LinkedList<>();
    }

    public void addCompanionProduct (Product product) {
        companionProducts.add(product);
    }
}
