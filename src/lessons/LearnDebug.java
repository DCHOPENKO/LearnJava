package lessons;

import lessons.for_test.Calculator;

public class LearnDebug {
    public static void main(String[] args) {

        int a = 10;

        int b = 10;

        for (int i = 0; i < 20; i++) {
            System.out.print((i + 9 + 63 * 2) + "\t");
        }

        Calculator calculator = new Calculator();

        System.out.println(calculator.sum(5, 2));

        calculator.sum(5, 2);

    }
}
