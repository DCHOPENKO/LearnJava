package homeworks.basic_tasks.speeddating;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService {
    private final static Scanner READER = new Scanner(System.in);
    private static List<Person> people;

    public PersonService() {
        people = new ArrayList<>();
        addSomePeopleToDB();
    }

    private static void addSomePeopleToDB() {
        people.add(new Person(
                "Vasya", "Pupkin", "Ukraine", "Kiev",
                30, 0, Sex.MALE));
        people.add(new Person(
                "Nickolay", "Nemerich", "Ukraine", "Kiev",
                30, 0, Sex.MALE));
        people.add(new Person(
                "Ekaterina", "Lohtenko", "Ukraine", "Kiev",
                33, 1, Sex.FEMALE));
        people.add(new Person(
                "Ivan", "Durov", "Russia", "Moscow",
                20, 0, Sex.MALE));
        people.add(new Person(
                "Nicky", "Perry", "USA", "Washington",
                26, 1, Sex.FEMALE));
        people.add(new Person(
                "Ann", "Karenina", "Russia", "Moscow",
                23, 0, Sex.FEMALE));
        people.add(new Person(
                "Veronika", "Karaga", "Belarus", "Minsk",
                43, 2, Sex.FEMALE));
    }



    public Person createNewPerson() throws IOException {
        System.out.print("Input FirstName:  ");
        String name = validateText();
        System.out.print("Input SecondName:  ");
        String surname = validateText();
        System.out.print("Input countryName:  ");
        String country = validateText();
        System.out.print("Input cityName:  ");
        String city = validateText();
        System.out.print("Input age:  ");
        int age = READER.nextInt();
        if (age <= 0 || age > 100) {
            throw new IOException("Incorrect input");
        } else if (age > 0 && age < 18) {
            throw new IOException("Access denied, only 18+");
        }
        System.out.print("Input number of children:  ");
        int childrenQty = READER.nextInt();
        if (childrenQty < 0 || childrenQty > 40) {
            throw new IOException("Incorrect input");
        }
        System.out.print("Input sex (m -male, f - female):  ");
        String sexValue = validateText();
        Sex sex = validateSexInput(sexValue);
        return new Person(name, surname, country, city, age, childrenQty, sex);
    }

    public void addNewPersonToDB(Person person) {
        people.add(person);
    }


    public void searchByAge(Person user) {
        List<Person> list = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() >= (user.getAge() - 5) && person.getAge() <= (user.getAge() + 5)
                    && !person.getSex().equals(user.getSex())) {
                list.add(person);
            }
        }
        printPeopleInfo(list);
    }

    public  void searchBySex(Person user) {
        List<Person> list = new ArrayList<>();
        for (Person person : people) {
            if (!person.getSex().equals(user.getSex())) {
                list.add(person);
            }
        }
        printPeopleInfo(list);
    }


    private void printPeopleInfo(List<Person> list) {
        int index = 1;
        for (Person person : list) {
            System.out.println("Details for user №" + index++ + "\n" + person);
        }
    }

    public void searchByNameAndSurname(String firstName, String lastName) throws IOException {
        List<Person> list = new ArrayList<>();
        boolean searchSuccess = false;
        for (Person person : people) {
            if (person.getName().equals(firstName) && person.getSurname().equals(lastName)) {
                list.add(person);
                searchSuccess = true;
            }
        }
        if (!searchSuccess) {
            System.out.println("No any results");
        }
        printPeopleInfo(list);
    }

    public void searchByCustomOptions (String city, Sex sex, int age, int childernQty) {
        List<Person> list = new ArrayList<>();
        boolean searchSuccess = false;
        for (Person person : people) {
            if (person.getCity().equals(city) && person.getSex().equals(sex)
                    && person.getAge() == age && person.getChildrenQty() == childernQty) {
                list.add(person);
                searchSuccess = true;
            }
        }
        if (!searchSuccess) {
            System.out.println("No any results");
        }
        printPeopleInfo(list);
    }

    public static Sex validateSexInput (String value) throws IOException {
        Sex sex = Sex.NOT_SET;
        if (value.equals("m")) {
            sex = Sex.MALE;
        } else if (value.equals("f")) {
            sex = Sex.FEMALE;
        } else {
            throw new IOException("Incorrect input");
        }
        return sex;
    }

    public String validateText() throws IOException {
        String checkText = READER.next();
        if (checkText.equals("")) {
            throw new IOException("Incorrect Input");
        }
        return checkText;
    }

    public int inputIntValue() {
        int value = READER.nextInt();
        return value;
    }

    public void closeScanner () {
        READER.close();
    }

}
