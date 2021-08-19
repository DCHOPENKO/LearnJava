package homeworks.basic_tasks.patterns.decorator;



public class Decorator {
    public static void main(String[] args) {
        Printable printable = new SquareBracketDecorator(new FigureBracketDecorator(new QuotesDecorator(
                new RealPrinter("Hello"))));
        printable.print();

    }
}


