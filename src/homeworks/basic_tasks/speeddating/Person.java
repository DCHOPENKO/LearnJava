package homeworks.basic_tasks.speeddating;

public class Person {
    private String name;
    private String surname;
    private String country;
    private String city;
    private int age;
    private int childrenQty;
    private Sex sex;

    Person(String name, String surname, String country, String city, int age, int childrenQty, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.age = age;
        this.childrenQty = childrenQty;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public int getChildrenQty() {
        return childrenQty;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {

        return "имя: " + name +
                ", Фамилия: " + surname
                + "\n Страна: " + country +
                " город: " + city
                + "\n Возраст - " + age +
                ", пол: " + sex;
    }

}



