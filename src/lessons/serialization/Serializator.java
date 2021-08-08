package lessons.serialization;

import java.io.*;
import java.util.Random;

public class Serializator {
    public static void main(String[] args) {
        ForSerializator john = new ForSerializator("John", 23);

        try (FileOutputStream fos = new FileOutputStream("Info.txt");
             final ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream("Info.txt");
             final ObjectInputStream ois = new ObjectInputStream(fis)) {
            oos.writeObject(john);

            final ForSerializator object = (ForSerializator) ois.readObject();

            System.out.println(object);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ForSerializator implements Serializable {
    private String name;
    private int age;

    private static final long serialVersionUID = 1L;


    public ForSerializator(String name, int age) {
        System.out.println("Constructor");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ForSerializator{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
