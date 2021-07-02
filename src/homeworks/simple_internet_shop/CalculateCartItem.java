package homeworks.simple_internet_shop;

import java.math.BigDecimal;

@FunctionalInterface
interface CalculateCartItem {
    BigDecimal calculate(CartProduct instance);
}
