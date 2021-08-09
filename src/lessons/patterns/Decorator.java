package lessons.patterns;

import java.io.FileReader;
import java.io.Reader;

/**
 *  СТРУКТУРНЫЙ ШАБЛОН ПРОЕКТИРОВАНИЯ, предназначенный для динамического подключения дополнительного поведения
 *  к объекту. Шаблон Декоратор предоставляет гибкую альтернативу практике создания
 *  подклассов с целью расширения функциональности.
 */
public class Decorator {
    public static void main(String[] args) {
        Printable printable = new QuotesDecorator(new LeftBracketDecorator(new RigthBracketDecorator(new RealPrinter("Hello!"))));
        printable.print();//"[Hello]""

    }
}

interface Printable {
    void print();
}

class RealPrinter implements Printable {

    private String text;

    public RealPrinter(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.print(text);
    }

}

class LeftBracketDecorator implements Printable {

    Printable printable;

    public LeftBracketDecorator(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        System.out.print("[");
        printable.print();
    }
}

class RigthBracketDecorator implements Printable {
    Printable printable;

    public RigthBracketDecorator(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        printable.print();
        System.out.print("]");
    }
}

class QuotesDecorator implements Printable {

    Printable printable;

    public QuotesDecorator(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        System.out.print("\"");
        printable.print();
        System.out.print("\"");
    }
}

