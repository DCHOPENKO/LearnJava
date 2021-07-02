package homeworks.simple_internet_shop;

import java.util.HashSet;
import java.util.Set;

public class ProductService implements CommonOperations {
    private Set<Product> productSet;

    public ProductService() {
        productSet = new HashSet<>();
    }

    public void addProduct(Product product) {
        productSet.add(product);
    }

    public void removeProduct(Product product) {
        product = getProductByParams(product, productSet);
        if (!existsProduct(product)) {
            return;
        }
        productSet.remove(product);
    }

    public void removeProductWithCompanions(Product product) {
        productSet.removeAll(getCompanionProducts(product));
        removeProduct(product);
    }

    public Product getProductByParams(Product product) {
        Product instance = getProductByParams(product, productSet);
        return instance;
    }

    public Set<Product> getCompanionProducts(Product product) {
        return getCompanionProductSet(product, productSet);
    }

    public void printCustomSet(Set<Product> set) {
        for (Product instance : set) {
            System.out.println(instance);
        }
    }

    public void printFullProductSet() {
        printCustomSet(productSet);
    }

    public void printCompanionProductsSet(Product product) {
        printCustomSet(getCompanionProducts(product));
    }

}

