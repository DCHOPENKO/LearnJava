package homeworks.simple_internet_shop;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ShoppingCart implements CommonOperations {
    private Set<Product> shoppingCart;

    ShoppingCart() {

        shoppingCart = new HashSet<>();
    }

    public void addToCart(Product product, int qty) {
        if (!existsProduct(product)) {
            return;
        }
        if (qty > product.getQtyOnWH() || qty <= 0) {
            System.out.println(getWarningMessage(product));
            return;
        }
        product.setQtyInCart(qty);
        calculateProductPriceInCart(product);
        shoppingCart.add(product);
    }

    public void addToCartWithCompanions(Product product, int qty, Set<Product> list) {
        addToCart(product, qty);
        for (Product instance : list) {
            addToCart(instance, qty);
        }
    }

    public void removeProductFromCart(Product product) {
        removeProductFromList(product, shoppingCart);
    }

    public void removeWithCompanionsfromCart(Product product) {
        removeProductWithCompanionsFromList(product, shoppingCart);
    }

    public void changeQtyValue(Product product, int newQty) {
        product = getByParams(product);
        if (!existsProduct(product)) {
            return;
        }
        if (newQty > product.getQtyOnWH() || newQty <= 0) {
            System.out.println(getWarningMessage(product));
            return;
        }
        removeProductFromCart(product);
        product.setQtyInCart(newQty);
        calculateProductPriceInCart(product);
        shoppingCart.add(product);
    }

    public Product getByParams(Product product) {
        return getProductByParams(product, shoppingCart);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : shoppingCart) {
            totalPrice += product.getPriceInCart();
        }
        return totalPrice;
    }

    public void calculateProductPriceInCart(Product product) {
        product.setPriceInCart(product.getPrice() * product.getQtyInCart());

//        CalculateCart cart = set -> {};
    }

    private String getWarningMessage(Product product) {
        return "Not enough items on WH, available to order --> " + product.getQtyOnWH() +
                " pcs. Or input qty value <= 0";

    }

    @Override
    public String toString() {
        if (shoppingCart.isEmpty()) {
            return "Cart is empty";
        }
        StringBuilder result = new StringBuilder("Shopping cart: \n");
        for (Product product : shoppingCart) {
            result.append("ProductID --> ").append(product.getProductId()).append("; BrandName --> ")
                    .append(product.getBrandName()).append("; ModelName --> ").append(product.getModelName())
                    .append("; Unit Price --> ").append(product.getPrice()).append("; Qty in Cart --> ")
                    .append(product.getQtyInCart()).append("; Total Price --> ")
                    .append(product.getPriceInCart()).append("\n");
        }
        result.append("----------------------------------------------------------------------------------------- \n")
                .append("                                                                 Grand Total Price -->")
                .append(BigDecimal.valueOf(calculateTotalPrice()).setScale(2, BigDecimal.ROUND_CEILING));
        return result.toString();
    }
}

@FunctionalInterface
interface CalculateCart {
    BigDecimal calculate(Set<Product> products);
}
