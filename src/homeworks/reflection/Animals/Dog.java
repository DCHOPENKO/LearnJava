package homeworks.reflection.Animals;

public class Dog extends Animal implements Eatable, Movable, Jumping {
    public String nickName;
    private int age;

    public Dog(String name, int age) {
        super(name);
        this.age = age;
        nickName = "someName";
    }

    private int getAge() {
        return age;
    }

    private void bark (String name, String barkType, int abc) {

    }

    public void eat() {
        System.out.println("dog " + getName() + " eating");
    }

}
