package homeworks.basic_tasks.stream_api;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamApiTasks {


    public static void main(String[] args) {
        List<Man> people = initSourceData();


        // - Вывести информацию о всех людях.
        people.forEach(System.out::println);

        // - Вывести информацию о всех адресах.
        Consumer<Man> consumer = m -> System.out.println(m.getAddress());

        people.forEach(consumer);

        // - Вывести firstName, lastName, countOfChildren, когда возраст более или равно 20 и отсортировать по firstName.
        consumer = h -> System.out.println(h.getFirstName() + " " + h.getSecondName() + " " + h.getCountOfChildren());
        Comparator<Man> comparator = (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName());

        people
                .stream()
                .filter(h -> h.getAge() >= 20)
                .sorted(comparator)
                .forEach(consumer);

        // - Изменить firstName = 'John', lastName = 'Kennedi', countOfChildren = 3, когда country == 'US' (or another country).
        List<Man> people2 = initSourceData();

        consumer = (h) -> {
            if (h.getAddress().getCountry().equals("USA")) {
                h.setFirstName("John");
                h.setSecondName("Kennedi");
                h.setCountOfChildren(3);
            }
        };

        people2
                .stream()
                .peek(consumer)
                .forEach(System.out::println);

        // - Вывести firstName, lastName, nameOfStreet, когда country == 'Canada' AND numberOfHome == 3 OR age >= 25";

        consumer = h -> System.out.println(h.getFirstName() + " " + h.getSecondName() + " " +
                h.getAddress().getStreet());

        people
                .stream()
                .filter(h -> {
                    Address address = h.getAddress();
                    return address.getCountry().equals("Canada") && address.getHouseNumber() == 3 ||
                            h.getAge() >= 25;
                })
                .forEach(consumer);

        // - Сгруппировать людей по количеству детей.

        Map<Integer, List<Man>> listMap =
                people
                        .stream()
                        .collect(Collectors.groupingBy(Man::getCountOfChildren));

        // - Сгруппировать людей по количеству детей и возрасту.

        class ForMan {
            private int CountOfChildren;
            private int age;

            public ForMan(int countOfChildren, int age) {
                CountOfChildren = countOfChildren;
                this.age = age;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                ForMan forMan = (ForMan) o;
                return CountOfChildren == forMan.CountOfChildren && age == forMan.age;
            }

            @Override
            public int hashCode() {
                return Objects.hash(CountOfChildren, age);
            }
        }

        Map<ForMan, List<Man>> listMap1 =
                people
                        .stream()
                        .collect(Collectors.groupingBy(h -> new ForMan(h.getCountOfChildren(), h.getAge())));

        // - Сгруппировать людей по городу и названию улицы.

        Map<AbstractMap.SimpleEntry<String, String>, List<Man>> listMap2 =
                people
                        .stream()
                        .collect(Collectors.groupingBy(h -> new AbstractMap.SimpleEntry<>(h.getAddress().getCity(),
                                h.getAddress().getStreet())));

        // - Сгруппировать людей по городу и названию улицы и вывести количество адресов, где количество людей больше 4.

        long result = people
                .stream()
                .collect(Collectors.groupingBy(h -> new AbstractMap.SimpleEntry<>(h.getAddress().getCity(),
                        h.getAddress().getStreet()), Collectors.counting()))
                .values()
                .stream()
                .filter(a -> a > 4)
                .count();

        System.out.println(result);

    }

    public static List<Man> initSourceData() {
        List<Man> people = new LinkedList<>();
        people.add(new Man("John", "Travolta", 34, 0,
                new Address("USA", "New York", "Wall street", 12)));
        people.add(new Man("Sara", "Connor", 14, 0,
                new Address("Canada", "Vancouver", "Main street", 3)));
        people.add(new Man("Alex", "Bolduin", 38, 3,
                new Address("Canada", "Vancouver", "Main street", 16)));
        people.add(new Man("Vasya", "Pupkin", 21, 1,
                new Address("Russia", "Moscow", "Maroseyka street", 15)));
        people.add(new Man("Bruce", "Wayne", 50, 5,
                new Address("USA", "Los Angeles", "California street", 63)));
        people.add(new Man("Ivan", "Ivanov1", 50, 5,
                new Address("Russia", "Ivanvo", "Lenin's street", 6)));
        people.add(new Man("Ivan", "Ivanov2", 50, 5,
                new Address("Russia", "Ivanvo", "Lenin's street", 6)));
        people.add(new Man("Ivan", "Ivanov3", 50, 5,
                new Address("Russia", "Ivanvo", "Lenin's street", 6)));
        people.add(new Man("Ivan", "Ivanov4", 50, 5,
                new Address("Russia", "Ivanvo", "Lenin's street", 6)));
        people.add(new Man("Ivan", "Ivanov5", 50, 5,
                new Address("Russia", "Ivanvo", "Lenin's street", 6)));
        people.add(new Man("Bruce", "Wayne2", 50, 5,
                new Address("USA", "Los Angeles", "California street", 63)));
        people.add(new Man("Bruce", "Wayne3", 50, 5,
                new Address("USA", "Los Angeles", "California street", 63)));
        people.add(new Man("Bruce", "Wayne4", 50, 5,
                new Address("USA", "Los Angeles", "California street", 63)));
        people.add(new Man("Bruce", "Wayne5", 50, 5,
                new Address("USA", "Los Angeles", "California street", 63)));
        return people;
    }




}

class Man {

    private String firstName;
    private String secondName;
    private int age;
    private int countOfChildren;
    private Address address;

//    имя, фамилия, возраст, количество детей, Адрес

    public Man(String firstName, String secondName, int age, int countOfChildren, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.countOfChildren = countOfChildren;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public int getCountOfChildren() {
        return countOfChildren;
    }

    public void setCountOfChildren(int countOfChildren) {
        this.countOfChildren = countOfChildren;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Man{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", countOfChildren=" + countOfChildren +
                ", address=" + address +
                '}';
    }
}

class Address {
    private String Country;
    private String city;
    private String street;
    private int houseNumber;

//    Адрес(страна, город, улица, номер дома)

    public Address(String country, String city, String street, int houseNumber) {
        Country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Country='" + Country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}




