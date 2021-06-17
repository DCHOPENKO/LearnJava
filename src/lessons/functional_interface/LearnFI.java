package lessons.functional_interface;

import java.util.function.Function;

public class LearnFI {
    public static void main(String[] args) {
        Calculatable calculatable = new Calculatable() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };

        Calculatable calc = (a, b) -> a + b;

//        System.out.println(calc.sum(4, 5));

        Convertable<String, Integer> convertable = s -> Integer.parseInt(s);

    }
}

//@FunctionalInterface
interface Calculatable {
    int sum(int a, int b);
//    int sum1(int a, int b);
}

@FunctionalInterface
interface Convertable<T, F> {
    F convert(T t);
}
