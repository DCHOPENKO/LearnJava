package homeworks.basic_tasks.calculator;

import java.util.Random;

public class CalculatorRandomValues {

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

    public int getOperandOne() {
        return  new Random().nextInt(100);
    }

    public int getOperandTwo() {
        return  new Random().nextInt(300);
    }


}
