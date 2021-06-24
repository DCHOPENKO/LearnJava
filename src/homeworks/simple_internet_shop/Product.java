package homeworks.simple_internet_shop;

import java.time.Year;
import java.util.Objects;

public class Product {

    private static int globalId = 778432;
    private Category category;
    private String subCategory;//enum
    private String modelName;
    private String brandName;
    private int year;//
    private Year year1;//
    private double price;
    private int qtyOnWH;
    private int productId;
    private int qtyInCart;
    private double priceInCart;

    private Product() {
    }

    public Product(Category category, String subCategory, String modelName, String brandName,
                   int year, double price, int qty) {
        this.category = category;
        this.subCategory = subCategory;
        this.modelName = modelName;
        this.brandName = brandName;
        this.year = year;
        this.price = price;
        this.qtyOnWH = qty;
        productId = globalId++;
    }

    public static Product buildWithCategoryAndModel(Category category, String modelName) {
        Product product = new Product();
        product.category = category;
        product.modelName = modelName;
        return product;
    }

    public static Product buildWithCategoryAndModelAndBrand(Category category, String modelName, String brandName) {
        Product product = buildWithCategoryAndModel(category, modelName);
        product.brandName = brandName;
        return product;
    }

    public double getPriceInCart() {
        return priceInCart;
    }

    public void setPriceInCart(double priceInCart) {
        this.priceInCart = priceInCart;
    }

    public Category getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getModelName() {
        return modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyOnWH() {
        return qtyOnWH;
    }

    public int getProductId() {
        return productId;
    }

    public int getQtyInCart() {
        return qtyInCart;
    }

    public void setQtyInCart(int qtyInCart) {
        this.qtyInCart = qtyInCart;
    }

    @Override
    public String toString() {
        return "ProductID --> " + productId + "; Category --> " + category.toString() +
                "; SubCategory --> " + subCategory + "; BrandName --> " + brandName + "; ModelName --> " + modelName +
                "; Year --> " + year + "; Price --> " + price + "; Qty --> " + qtyOnWH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return category.equals(product.category) && modelName.equals(product.modelName)
                && brandName.equals(product.brandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, modelName, brandName);
    }
}