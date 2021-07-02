package homeworks.simple_internet_shop;

import java.math.BigDecimal;
import java.util.Objects;

public class CartProduct {
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public CartProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Category --> " + product.getCategory() + "; SubCategory --> " + product.getSubCategory() +
                "; BrandName --> " + product.getBrandName() + "; ModelName --> " + product.getModelName() +
                "; Unit Price --> " + product.getPrice().setScale(2, BigDecimal.ROUND_CEILING) +
                "; Qty in Cart --> " + quantity + "; Total Price --> " +
                totalPrice.setScale(2, BigDecimal.ROUND_CEILING);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartProduct that = (CartProduct) o;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
