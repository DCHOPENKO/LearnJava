package homeworks.basic_tasks.stream_api.binary_operator;

import java.util.ArrayList;
import java.util.List;

public class ForTest {

    public static void main(String[] args) {
        Person person1 = new Person("Vasya", "Pupkin");
        Person person2 = new Person("Petya", "Ivanov");
        Person person3 = new Person("Ben", "Aflek");

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        List<String> greetings = App.createGreetings(persons, App.greetingOperator);

        greetings.forEach(System.out::println);

    }
}
