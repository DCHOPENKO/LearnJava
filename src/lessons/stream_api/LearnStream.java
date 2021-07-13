package lessons.stream_api;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LearnStream {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("John", 12),
                new Human("John", 12),
                new Human("Steeve", 30),
                new Human("Ben", 45)
        );
      /*  Stream<Human> humanStream = Stream.of(
                new Human("John", 23),
                new Human("Jack", 12),
                new Human("Steeve", 30),
                new Human("Ben", 45)
        );*/

        Predicate<Human> predicate = h -> h.getAge() > 20;

        Consumer<Human> consumer = h -> System.out.println(h);
        /*humans
                .stream()
                .filter(predicate)
                .forEach(consumer);*/

       /* System.out.println(humans.stream()
                .mapToInt(h -> h.getAge())
                .sum());*/

//        Function<Human, Child> function = h -> new Child(h.getName(), h.getAge());
        Function<Human, Child> function = Child::new;

     /*   humans.stream()
                .map(function)
                .forEach(System.out::println);*/

        Set<Child> children = humans.stream()
                .map(h -> {
                    return new Child(h.getName(), h.getAge());
                })
                .collect(Collectors.toSet());

//        humans.stream().distinct()
//        boolean match = humans.stream().anyMatch(h -> h.getAge() > 20);
//        humans.stream().allMatch()

      /*  Map<Integer, List<Human>> map = humans.stream()
                .collect(Collectors.groupingBy(h -> h.getAge() % 2));*/

        Map<Integer, Long> map = humans.stream()
                .collect(Collectors.groupingBy(h -> h.getAge() % 2, Collectors.counting()));

        System.out.println();

        Comparator<Human> comparatorAge = (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());
        Comparator<Human> comparatorName = (o1, o2) -> o1.getName().compareTo(o2.getName());

        humans
                .stream()
//                .sorted()
                .sorted(comparatorAge.thenComparing(comparatorName))
                .forEach(h -> System.out.println(h));

//        Collections.sort(humans);

    }
}

class GroupHuman {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("John", 12),
                new Human("John", 12),
                new Human("Steeve", 30),
                new Human("Ben", 45)
        );

        Map<Integer, Map<String, List<Human>>> map = humans.stream()
                .collect(Collectors.groupingBy(Human::getAge, Collectors.groupingBy(h -> h.getName())));

        class ForHuman {
            private String name;
            private int age;

            public ForHuman(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                ForHuman forHuman = (ForHuman) o;
                return age == forHuman.age && Objects.equals(name, forHuman.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, age);
            }
        }

        int[] count = new int[1];

        IntStream.range(0, humans.size()).forEach(index -> {

            System.out.println(humans.get(index));
            count[0] += 1;
        });

//        humans.forEach(h -> System.out.println(h));

        /*Map<ForHuman, List<Human>> listMap = humans.stream()
                .collect(Collectors.groupingBy(h -> new ForHuman(h.getName(), h.getAge())));*/

        Map<AbstractMap.SimpleEntry<String, Integer>, List<Human>> map1 =
                humans
                        .stream()
                .collect(Collectors.groupingBy(h -> new AbstractMap.SimpleEntry<>(h.getName(), h.getAge())));

        System.out.println();

    }
}

class Human implements Comparable<Human> {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Human o) {
        return Integer.compare(o.getAge(), age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Child {
    private String name;
    private int age;

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Child(Human human) {
        this.name = human.getName();
        this.age = human.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
