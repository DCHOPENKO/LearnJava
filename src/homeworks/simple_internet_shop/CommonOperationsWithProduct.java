package homeworks.simple_internet_shop;

import java.util.HashSet;
import java.util.Set;

public interface CommonOperationsWithProduct {
    Product EMPTY_PRODUCT = new Product(Category.UNCLASSIFIED,
            "", "", "", 0, 0, 0);

    default Product getByParams(Product product, Set<Product> list) {
        for (Product instance : list) {
            if (instance.getCategory().equals(product.getCategory())
                    && instance.getModelName().equals(product.getModelName())
                    && instance.getBrandName().equals(product.getBrandName())) {
                return instance;
            }
        }
        return EMPTY_PRODUCT;
    }

    default boolean isProductInList(Product product) {
        if (product.getCategory().equals(Category.UNCLASSIFIED)) {
            System.out.println("No such product in list");
            return false;
        }
        return true;
    }

    default void removeProductFromList(Product product, Set<Product> list) {
        product = getByParams(product, list);
        if (!isProductInList(product)) {
            return;
        }
        list.remove(product);
    }

    default void removeProductWithCompanionsFromList(Product product, Set<Product> list) {
        if (!isProductInList(product)) {
            return;
        }
        list.removeAll(getCompanionProductList(product, list));
        removeProductFromList(product, list);
    }

    default Set<Product> getCompanionProductList(Product product, Set<Product> list) {
        product = getByParams(product, list);
        Set<Product> companionList = new HashSet<>();
        for (Product instance : list) {
            if (instance.getCategory().equals(product.getCategory())
                    && !instance.getSubCategory().equals(product.getSubCategory())) {
                companionList.add(instance);
            }
        }
        return companionList;
    }
}
