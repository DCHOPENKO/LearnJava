package homeworks.basic_tasks.map.price_explorer_by_map;

import java.time.Month;
import java.util.List;

public class PriceExplorerMap {
    private List<ProductInstanceMap> list;

    PriceExplorerMap(List<ProductInstanceMap> list) {
        this.list = list;
    }

    public double getPrice(Month month, String productName) {
        for (ProductInstanceMap product : list) {
            if (product.getName().equals(productName) && product.getPriceDetails().containsKey(month)) {
                return product.getPriceDetails().get(month);
            }
        }
        return -999;
    }

}
