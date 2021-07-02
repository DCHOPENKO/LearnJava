package homeworks.basic_tasks.map.price_explorer_by_map;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<ProductInstanceMap> list = getProductInstances();
        PriceExplorerMap priceExplorer = new PriceExplorerMap(list);

        System.out.println(priceExplorer.getPrice(Month.JANUARY, "prod_1"));
        System.out.println(priceExplorer.getPrice(Month.JANUARY, "prod_2"));

        for (ProductInstanceMap event : list) {
            System.out.println(event.getPriceDetails());
        }
    }

    public static List<ProductInstanceMap> getProductInstances() {
        List<ProductInstanceMap> list = new ArrayList<>();
        ProductInstanceMap prod1 = new ProductInstanceMap("prod_1");
        prod1.setPriceDetails(new Month[]{Month.JANUARY, Month.FEBRUARY, Month.MARCH},
                new double[]{300, 500, 700});
        ProductInstanceMap prod2 = new ProductInstanceMap("prod_2");
        prod2.setPriceDetails(new Month[]{Month.JANUARY, Month.FEBRUARY, Month.MARCH},
                new double[]{100, 200, 300});
        list.add(prod1);
        list.add(prod2);
        return list;
    }
}
