package lessons.for_test;

import java.util.Random;

public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public void print() {
        System.out.println("Hello");
    }

    public int sumRandom(int a) {
//        print();
        return a + getRandom();
    }

    public int getRandom() {
        return new Random().nextInt(50);
    }

    public static int sumStatic(int value) {
        return value + getRandomStatic();
    }

    public static int getRandomStatic() {
        return new Random().nextInt(50);
    }

    public int sumRandomPrivate(int value) {
        return value + getRandomPrivate();
    }

    private int getRandomPrivate() {
        return new Random().nextInt(50);
    }

}
