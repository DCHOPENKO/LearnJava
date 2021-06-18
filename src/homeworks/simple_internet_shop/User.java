package homeworks.simple_internet_shop;

import java.util.LinkedList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    ShoppingCart shoppingCart;

    User (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        shoppingCart = new ShoppingCart();
    }

}
