package homeworks.basic_tasks.speech;

import java.util.Random;

public abstract class Human {
    private static final Random RANDOM = new Random();
    private static final String[] NAMES = {"Александр", "Андрей", "Анастасия", "Ирина", "Наталья",
            "Павел", "Роман", "Светлана", "Сергей", "Татьяна"};
    private String name = NAMES[RANDOM.nextInt(NAMES.length)];//[0,50)
    private int age = RANDOM.nextInt(20) + 20;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    abstract void sayHello(Human human);

    public void introduceBriefly() {
        System.out.print("Меня зовут " + name + " " + getAgeInText(age));
    }

    private String getAgeInText(int age) {
        String ageInText = "";
        if (age == 1 || age == 21 || age == 31) {
            ageInText = " год";
        } else if ((age >= 2 && age <= 4) || (age >= 22 && age <= 24) ||
                (age >= 32 && age <= 34)) {
            ageInText = " года";
        } else {
            ageInText = " лет";
        }
        return " мой возраст " + age + ageInText;
    }
}
