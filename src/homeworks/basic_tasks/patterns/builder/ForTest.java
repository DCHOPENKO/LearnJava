package homeworks.basic_tasks.patterns.builder;

public class ForTest {

    public static void main(String[] args) {
        Pizza favoritePizza = cook();

        SqlRequest request = SqlRequest.create()
                .buildParameter("address")
                .buildParameter("age")
                .buildTableName("people")
                .buildCondition("age > 20")
                .buildCondition("city = Moscow")
                .buildSelector(Selector.AND)
                .build();

        System.out.println(request);

    }

    public static Pizza cook() {
        return Pizza.base()
                .addCheese("cheese")
                .addMushroom("mushroom")
                .addMeat("meat")
                .build();
    }
}
