package homeworks.simple_internet_shop;

public class User {
    private ShoppingCart shoppingCart;
    private String firstName;
    private String lastName;
    private String password;

    User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        shoppingCart = new ShoppingCart();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

}
