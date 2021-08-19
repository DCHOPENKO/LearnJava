package homeworks.basic_tasks.patterns.decorator;

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
