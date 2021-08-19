package homeworks.basic_tasks.patterns.decorator;

class FigureBracketDecorator implements Printable {

    Printable printable;

    public FigureBracketDecorator(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        System.out.print("{");
        printable.print();
        System.out.print("}");
    }
}
