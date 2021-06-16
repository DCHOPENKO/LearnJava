package homeworks.basic_tasks.speech;

public class Realist extends Human {
    private static final String REALIST = "Реалист";
    private String name;
    private int age;

    Realist() {
        name = super.getName();
        age = super.getAge();
    }

    @Override
    public void sayHello(Human human) {
        if ((this.age + 5) > human.getAge()) {
            System.out.println(name + ": Привет, " + human.getName() + "!");
        } else {
            System.out.println(name + ": Здравствуй, " + human.getName());
        }
    }

    @Override
    public void introduceBriefly() {
        super.introduceBriefly();
        System.out.println(", я " + REALIST);
    }

}
