package homeworks.simple_internet_shop;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Objects;

public class Product {

    private Category category;
    private String subCategory;
    private String modelName;
    private String brandName;
    private Year year;
    private BigDecimal price;
    private int quantityOnWH;

    public Product(Category category, String subCategory, String modelName, String brandName,
                   Year year, double price, int quantity) {
        this.category = category;
        this.subCategory = subCategory;
        this.modelName = modelName;
        this.brandName = brandName;
        this.year = year;
        this.price = BigDecimal.valueOf(price);
        this.quantityOnWH = quantity;
    }

    public Product(Category category, String modelName) {
        this.category = category;
        this.modelName = modelName;
    }

    public Product(Category category, String modelName, String brandName) {
        this.category = category;
        this.modelName = modelName;
        this.brandName = brandName;
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

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantityOnWH() {
        return quantityOnWH;
    }

    @Override
    public String toString() {
        return "Category --> " + category + "; SubCategory --> " + subCategory + "; BrandName --> " + brandName +
                "; ModelName --> " + modelName + "; Year --> " + year + "; Price --> " +
                price.setScale(2, BigDecimal.ROUND_CEILING) + "; Qty --> " + quantityOnWH;
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