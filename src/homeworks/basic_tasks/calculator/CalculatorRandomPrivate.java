package homeworks.basic_tasks.calculator;

import java.util.Random;

public class CalculatorRandomPrivate {

    public int multiply () {
        return getOperandOne()* getOperandTwo();
    }

    public int divide () {
        return getOperandOne() / getOperandTwo();
    }

    public int sum () {
        return getOperandOne() + getOperandTwo();
    }

    public int deduct () {
        return getOperandOne() - getOperandTwo();
    }

    public int getRemainderFromDividing () {
        return getOperandOne() % getOperandTwo();
    }

    private int getOperandOne() {
        return  new Random().nextInt(100);
    }

    private int getOperandTwo() {
        return  new Random().nextInt(300);
    }

}
