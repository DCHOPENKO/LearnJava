package homeworks.basic_tasks.collections;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class CollectionsTasks {
    private static List<ProductInstance> list = new ArrayList<>();

    static {
        list.add(new ProductInstance("prod_1", Month.JANUARY, 100));
        list.add(new ProductInstance("prod_1", Month.FEBRUARY, 110));
        list.add(new ProductInstance("prod_1", Month.MARCH, 100));
        list.add(new ProductInstance("prod_1", Month.APRIL, 110));
        list.add(new ProductInstance("prod_1", Month.MAY, 150));
        list.add(new ProductInstance("prod_1", Month.JUNE, 170));
        list.add(new ProductInstance("prod_1", Month.JULY, 190));
        list.add(new ProductInstance("prod_1", Month.AUGUST, 170));
        list.add(new ProductInstance("prod_1", Month.SEPTEMBER, 140));
        list.add(new ProductInstance("prod_1", Month.OCTOBER, 120));
        list.add(new ProductInstance("prod_1", Month.NOVEMBER, 110));
        list.add(new ProductInstance("prod_1", Month.DECEMBER, 90));
        list.add(new ProductInstance("prod_2", Month.JANUARY, 570));
        list.add(new ProductInstance("prod_2", Month.FEBRUARY, 600));
        list.add(new ProductInstance("prod_2", Month.MARCH, 650));
        list.add(new ProductInstance("prod_2", Month.MAY, 999));
    }

    public static void main(String[] args) {
        PriceExplorer ps = new PriceExplorer(list);
        System.out.println(ps.getPrice(Month.MARCH, "prod_1"));
        System.out.println(ps.getPrice(Month.MARCH, "prod_2"));
        System.out.println(ps.getPrice(Month.JANUARY, "prod_1"));
        System.out.println(ps.getPrice(Month.JANUARY, "prod_2"));
        System.out.println(ps.getPrice(Month.DECEMBER, "prod_1"));
    }
}
