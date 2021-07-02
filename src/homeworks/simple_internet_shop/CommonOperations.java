package homeworks.simple_internet_shop;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public interface CommonOperations {
    Product EMPTY_PRODUCT = new Product(Category.UNCLASSIFIED,
            "", "", "", Year.of(0), 0, 0);

    default Product getProductByParams(Product product, Set<Product> set) {
        for (Product instance : set) {
            if (instance.getCategory().equals(product.getCategory())
                    && instance.getModelName().equals(product.getModelName())
                    && instance.getBrandName().equals(product.getBrandName())) {
                return instance;
            }
        }
        return EMPTY_PRODUCT;
    }

    default boolean existsProduct(Product product) {
        if (product.getCategory().equals(Category.UNCLASSIFIED)) {
            System.out.println("No such product in list");
            return false;
        }
        return true;
    }

    default Set<Product> getCompanionProductSet(Product product, Set<Product> set) {
        product = getProductByParams(product, set);
        Set<Product> companionsSet = new HashSet<>();
        for (Product instance : set) {
            if (instance.getCategory().equals(product.getCategory())
                    && !instance.getSubCategory().equals(product.getSubCategory())) {
                companionsSet.add(instance);
            }
        }
        return companionsSet;
    }
}
