package homeworks.basic_tasks.stream_api.binary_operator;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

    /*    d) We have class Person {

    add to App class static field greetingOperator of type BinaryOperator.
    The greetingOperator should create a new string as e result by the rule: "Hello " + parameter1 + " " + parameter2 + "!!!"
    Create a static method createGreetings(...) that takes two parameters:  List<Person>  and BinaryOperator and generates
    List<String> as e result. We shoud be able to pass greetingOperator as a parameter here. Please use the second parameter in
            creating the result*/

public class App {
    static BinaryOperator<String> greetingOperator = (s1, s2) -> "Hello " + s1 + " " + s2 + "!!!";

    public static List<String> createGreetings(List<Person> persons, BinaryOperator<String> bo) {

        Function<Person, String> function = p -> bo.apply(p.getName(), p.getSurname());

        return persons.stream()
                .map(function)
                .collect(Collectors.toList());
    }


}
