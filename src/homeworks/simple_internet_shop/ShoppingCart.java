package homeworks.simple_internet_shop;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ShoppingCart implements CommonOperations {
    private Set<CartProduct> shoppingCart;

    ShoppingCart() {
        shoppingCart = new HashSet<>();
    }

    // get ProductSet  from CartProductSet
    private Set<Product> getProductSet() {
        Set<Product> productSet = new HashSet<>();
        for (CartProduct instance : shoppingCart) {
            productSet.add(instance.getProduct());
        }
        return productSet;
    }

    // get cartProduct by Product
    private CartProduct getCartProduct(Product product) {
        for (CartProduct instance : shoppingCart) {
            if (instance.getProduct().getModelName().equals(product.getModelName()) &&
                    instance.getProduct().getBrandName().equals(product.getBrandName())) {
                return instance;
            }
        }
        return new CartProduct(CommonOperations.EMPTY_PRODUCT, 0);
    }

    public void addProduct(Product product, int quantity) {
        if (!existsProduct(product)) {
            return;
        }
        if (quantity > product.getQuantityOnWH() || quantity <= 0) {
            System.out.println(getWarningMessage(product));
            return;
        }

        CartProduct cartProduct = new CartProduct(product, quantity);
        calculateProductTotalPrice(cartProduct);
        shoppingCart.add(cartProduct);
    }

    public void addWithCompanionProducts(Product product, int qty, Set<Product> set) {
        addProduct(product, qty);
        for (Product instance : set) {
            addProduct(instance, qty);
        }
    }

    public void removeProduct(Product product) {
        product = getProductByParams(product, getProductSet());
        if (!existsProduct(product)) {
            return;
        }
        shoppingCart.remove(getCartProduct(product));
    }

    public void removeWithCompanionProducts(Product product) {
        Set<Product> set = getCompanionProductSet(product, getProductSet());
        Set<CartProduct> cartProducts = new HashSet<>();
        cartProducts.add(getCartProduct(product));
        for (Product instance : set) {
            cartProducts.add(getCartProduct(instance));
        }
        shoppingCart.removeAll(cartProducts);
    }

    public void changeQuantity(Product product, int newQty) {
        CartProduct instance = getCartProduct(product);
        if (!existsProduct(instance.getProduct())) {
            return;
        }
        if (newQty > instance.getProduct().getQuantityOnWH() || newQty <= 0) {
            System.out.println(getWarningMessage(instance.getProduct()));
            return;
        }
        removeProduct(instance.getProduct());
        instance.setQuantity(newQty);
        calculateProductTotalPrice(instance);
        shoppingCart.add(instance);
    }

    public BigDecimal calculateCartTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartProduct instance : shoppingCart) {
            totalPrice = totalPrice.add(instance.getTotalPrice());
        }
        return totalPrice;
    }

    public void calculateProductTotalPrice(CartProduct cartProduct) {
        CalculateCartItem cart = cartItem ->
                BigDecimal.valueOf(cartItem.getQuantity()).multiply(cartItem.getProduct().getPrice());
        cartProduct.setTotalPrice(cart.calculate(cartProduct));
    }

    private String getWarningMessage(Product product) {
        return "Not enough items on WH, available to order --> " + product.getQuantityOnWH() +
                " pcs. Or input qty value <= 0";
    }

    @Override
    public String toString() {
        if (shoppingCart.isEmpty()) {
            return "Cart is empty";
        }
        StringBuilder result = new StringBuilder("Shopping cart: \n");
        for (CartProduct instance : shoppingCart) {
            result.append(instance).append("\n");
        }
        result.append("----------------------------------------------------------------------------------------- \n").
                append("                                                                 Grand Total Price -->").
                append(calculateCartTotalPrice().setScale(2, BigDecimal.ROUND_CEILING));
        return result.toString();
    }
}
