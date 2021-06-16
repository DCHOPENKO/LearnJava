package homeworks.basic_tasks.speech;

public class Neformal extends Human {
    private static final String NEFORMAL = "Неформал";
    private String name;
    private int age;

    Neformal() {
        name = super.getName();
        age = super.getAge();
    }

    @Override
    public void sayHello(Human human) {
        System.out.println(name + ": Привет, " + human.getName() + "!");
    }

    @Override
    public void introduceBriefly() {
        super.introduceBriefly();
        System.out.println(", я " + NEFORMAL);
    }

}
