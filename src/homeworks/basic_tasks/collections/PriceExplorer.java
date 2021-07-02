package homeworks.basic_tasks.collections;

import java.time.Month;
import java.util.List;

public class PriceExplorer {
    private List<ProductInstance> list;

    PriceExplorer (List<ProductInstance> list) {
        this.list = list;
    }

    public double getPrice (Month month, String productName) {
        for (ProductInstance product : list) {
            if (product.getName().equals(productName) && product.getMonth().equals(month)) {
                return  product.getPrice();
            }
        }
        return -999;
    }

}
