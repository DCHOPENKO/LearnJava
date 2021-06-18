package homeworks.simple_internet_shop;

import java.util.LinkedList;
import java.util.List;

public class ProductList {

    // add new product to productList
    // delete product from productList
    // delete product and companionProducts from productList
    // change qty value


    private List<Product> productList;
    private static ProductList instance;

    private ProductList() {
        productList = new LinkedList<>();
    }

    public static ProductList getInstance () {
        if (instance == null) {
            instance = new ProductList();
        }
        return instance;
    }

}
