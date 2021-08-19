package homeworks.basic_tasks.patterns.decorator;

class SquareBracketDecorator implements Printable {

    Printable printable;

    public SquareBracketDecorator(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        System.out.print("[");
        printable.print();
        System.out.print("]");
    }
}
