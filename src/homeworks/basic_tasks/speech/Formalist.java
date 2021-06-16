package homeworks.basic_tasks.speech;

public class Formalist extends Human {
    private static final String FORMALIST = "Формалист";
    private String name;
    private int age;

    Formalist() {
        name = super.getName();
        age = super.getAge();
    }

    @Override
    public void sayHello(Human human) {
        System.out.println(name + ": Здравствуй, " + human.getName());
    }

    @Override
    public void introduceBriefly() {
        super.introduceBriefly();
        System.out.println(", я " + FORMALIST);
    }


}




