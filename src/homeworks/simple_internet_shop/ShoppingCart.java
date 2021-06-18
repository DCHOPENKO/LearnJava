package homeworks.simple_internet_shop;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
    List<Product> shoppingCart;
    private double sumPrice;

    //  add new product to cart  (ask qty)
    //  add new product with companionProducts to cart  (ask qty)
    //  delete new product to cart (ask qty)
    //  delete new product with companionProducts to cart (ask qty)
    //  calculate sumPrice
    //  show cart in console

    ShoppingCart() {
        sumPrice = 0;
        shoppingCart = new LinkedList<>();
    }


}
