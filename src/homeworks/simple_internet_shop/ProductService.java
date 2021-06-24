package homeworks.simple_internet_shop;

import java.util.HashSet;
import java.util.Set;

public class ProductService implements CommonOperations {
    private Set<Product> productList;

    public ProductService() {
        productList = new HashSet<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProductFromList(Product product) {
        removeProductFromList(product, productList);
    }

    public void removeProductWithCompanionsFromList(Product product) {
        removeProductWithCompanionsFromList(product, productList);
    }

    public Product getByParams(Product product) {
        Product instance = getProductByParams(product, productList);
        return instance;
    }

    public Set<Product> getCompanionProductList(Product product) {
        return getCompanionProductList(product, productList);
    }

    public void printCustomList(Set<Product> customList) {
        for (Product instance : customList) {
            System.out.println(instance);
        }
    }

    public void printFullProductList() {
        printCustomList(productList);
    }

    public void printCompanionProductList(Product product) {
        printCustomList(getCompanionProductList(product));
    }

}

