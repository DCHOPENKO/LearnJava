package homeworks.basic_tasks.patterns.strategy;

public class Calculator {

    public static void execute(int a, int b, Strategy strategy) {
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }

    public static void main(String[] args) {

        Strategy addStrategy = (a, b) -> (a + b);
        Strategy subtractStrategy = (a, b) -> (a - b);
        Strategy multiplyStrategy = (a, b) -> (a * b);
        Strategy divideStrategy = (a, b) -> (a / b);

        execute(6, 3, addStrategy);
        execute(6, 3, subtractStrategy);
        execute(6, 3, multiplyStrategy);
        execute(6, 3, divideStrategy);

        execute(6, 3, (a, b) -> (a + b));
        execute(6, 3, (a, b) -> (a - b));
        execute(6, 3, (a, b) -> (a * b));
        execute(6, 3, (a, b) -> (a / b));
    }
}
