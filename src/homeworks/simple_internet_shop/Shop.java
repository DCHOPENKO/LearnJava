package homeworks.simple_internet_shop;

import java.time.Year;
import java.util.Set;

public class Shop {
    private static final Product HONOR_10 = new Product(Category.PHONES, "Honor 10", "Huawei");
    private static final Product TV_SAMSUNG = new Product(Category.TVS, "ML12VGT65", "Samsung");
    private static ProductService productList = new ProductService();

    public static void main(String[] args) {
        // 1) добавление товара(название, производитель, дата производства и т.д.).
        // 2) добавление сопутствующих товаров.
        System.out.println("1) добавление товара(название, производитель, дата производства и т.д.).\n" +
                "2) добавление сопутствующих товаров.");
        addProductsToShopList();
        productList.printFullProductSet();

        //        3) удаление товара без сопутствующих товаров.
        System.out.println("03.1 удаление товара без сопутствующих товаров.");
        printFullProductListWithTextBloc("Before");
        productList.removeProduct(TV_SAMSUNG);
        printFullProductListWithTextBloc("After");

//        3) удаление товара c сопутствующими товарами.
        System.out.println("03.2 удаление товара с сопутствующими товарами.");
        printFullProductListWithTextBloc("Before");
        productList.removeProductWithCompanions(HONOR_10);
        printFullProductListWithTextBloc("After");

        addProductsToShopList();

//        4) создание корзины для каждого юзера.
        User userVasya = new User("Vasya", "Pupkin", "password");
        User userPetya = new User("John", "Smith", "password");
        addProductToUserCart(userVasya, TV_SAMSUNG, 7);

        addProductToUserCart(userVasya, TV_SAMSUNG, 4);

        addProductWithCompanionsToUserCart(userPetya, HONOR_10, 2);

        printUserShoppingCart(userVasya);
        printUserShoppingCart(userPetya);

//      5) выбор товара по определенным критериям и после выводить сопутствующие товары.
        System.out.println("05. выбор товара по определенным критериям и после выводить сопутствующие товары \n" +
                " для продукта --> " + HONOR_10.getModelName());

        productList.printCompanionProductsSet(HONOR_10);

//     6)  удаление элементов из корзины
        System.out.println("6.1  удаление продукта из корзины");
        addProductWithCompanionsToUserCart(userVasya, HONOR_10, 3);
        System.out.println("Before");
        printUserShoppingCart(userVasya);
        removeProductFromUserCart(userVasya, HONOR_10);
        System.out.println("After");
        printUserShoppingCart(userVasya);

        System.out.println("6.1  удаление продуктf + сопуств. продукты из корзины");
        addProductToUserCart(userVasya, HONOR_10, 3);
        System.out.println("Before");
        printUserShoppingCart(userVasya);
        removeProductWithCompanionsFromUserCart(userVasya, HONOR_10);
        System.out.println("After");
        printUserShoppingCart(userVasya);

//     7)  редактирование кол-ва продуктов в корзине
        System.out.println("7)  редактирование кол-ва продуктов в корзине");
        System.out.println("Before");
        printUserShoppingCart(userVasya);
        changeProductQtyInUserCart(userVasya, TV_SAMSUNG, 2);
        System.out.println("After (in Cart was 4,  set 2");
        printUserShoppingCart(userVasya);


        System.out.println("After (in Cart was 2,  set 7");
        changeProductQtyInUserCart(userVasya, TV_SAMSUNG, 7);
        printUserShoppingCart(userVasya);
    }

    public static void addProductsToShopList() {
        productList.addProduct(new Product(Category.PHONES, "Mobile_Phones", "Honor 10",
                "Huawei", Year.of(2019), 600, 6));
        productList.addProduct(new Product(Category.PHONES, "Accessories", "phone Case",
                "RiK", Year.of(2019), 10, 56));
        productList.addProduct(new Product(Category.PHONES, "Earphones", "Honor AM 176",
                "Huawei", Year.of(2018), 50, 4));
        productList.addProduct(new Product(Category.PHONES, "Mobile_Phones", "Iphone 12",
                "Apple", Year.of(2020), 1100, 12));
        productList.addProduct(new Product(Category.TVS, "TV", "ML12VGT65",
                "Samsung", Year.of(2020), 3000, 5));
    }

    public static void printFullProductListWithTextBloc(String text) {
        System.out.println(text);
        productList.printFullProductSet();
    }

    public static void printUserShoppingCart(User user) {
        System.out.println("Корзина покупок --> " + user.getFirstName() + " " + user.getLastName());
        System.out.println(user.getShoppingCart());
    }

    public static void addProductToUserCart(User user, Product product, int qty) {
        user.getShoppingCart().addProduct(productList.getProductByParams(product), qty);
    }

    public static void addProductWithCompanionsToUserCart(User user, Product product, int qty) {
        Product params = productList.getProductByParams(product);
        Set<Product> productSet = productList.getCompanionProducts(product);
        user.getShoppingCart().addWithCompanionProducts(params, qty, productSet);
    }

    public static void removeProductFromUserCart(User user, Product product) {
        user.getShoppingCart().removeProduct(product);
    }

    public static void removeProductWithCompanionsFromUserCart(User user, Product product) {
        user.getShoppingCart().removeWithCompanionProducts(product);
    }

    public static void changeProductQtyInUserCart(User user, Product product, int newQty) {
        user.getShoppingCart().changeQuantity(productList.getProductByParams(product), newQty);
    }
}
