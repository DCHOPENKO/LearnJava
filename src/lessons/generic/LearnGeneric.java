package lessons.generic;

import java.util.concurrent.atomic.DoubleAdder;

public class LearnGeneric {
    public static void main(String[] args) {
        Calculator<Integer, String> calculator = new Calculator<>();

        CalculatorNotGeneric notGeneric = new CalculatorNotGeneric();

        notGeneric.<String, Integer>addElement("", 6);
    }
}

class CalculatorInteger {
    private int[] array;
}

class CalculatorDouble {
    private double[] array;
}

class Calculator<T extends Integer, F> {
    private T[] array;
    private F[] array1;

    public void addElement(T t) {
        array[0] = t;
    }

    public void print() {


        for (int i = 0; i < array.length; i++) {
//            array[i] = array[i] + 1;
        }

    }

}

class CalculatorNotGeneric {
    private int[] array;

    public <T extends Comparable<T>, F extends Number> void addElement(T t, F f) {

    }

    public void print() {


        for (int i = 0; i < array.length; i++) {
//            array[i] = array[i].intValue() + 1;
        }

    }

}
