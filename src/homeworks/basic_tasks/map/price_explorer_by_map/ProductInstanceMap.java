package homeworks.basic_tasks.map.price_explorer_by_map;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class ProductInstanceMap {
    private String name;
    private Map<Month, Double> priceDetails;

    ProductInstanceMap(String name) {
        this.name = name;
        priceDetails = new HashMap<>();
    }

    public void setPriceDetails(Month[] month, double[] price) {
        for (int i = 0; i < month.length; i++) {
            priceDetails.put(month[i], price[i]);
        }
    }

    public String getName() {
        return name;
    }

    public Map<Month, Double> getPriceDetails() {
        return priceDetails;
    }
}
