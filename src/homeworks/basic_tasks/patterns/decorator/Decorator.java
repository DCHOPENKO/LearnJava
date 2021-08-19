package homeworks.basic_tasks.patterns.decorator;


// Добавить функционал добавления к строке [] и {} к шаблону Декоратор, чтобы получить строку [{"Hello"}]

public class Decorator {
    public static void main(String[] args) {
        Printable printable = new SquareBracketDecorator(new FigureBracketDecorator(new QuotesDecorator(
                new RealPrinter("Hello"))));
        printable.print();

    }
}


