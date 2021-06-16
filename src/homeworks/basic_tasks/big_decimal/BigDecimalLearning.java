package homeworks.basic_tasks.big_decimal;

import java.math.BigDecimal;

public class BigDecimalLearning {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.1");
        System.out.println(a);
        BigDecimal b = new BigDecimal("1.100");

        System.out.println(a.setScale(2,BigDecimal.ROUND_CEILING));

        System.out.println(a.equals(b));
        System.out.println(a.compareTo(b));



    }

}
