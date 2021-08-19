package homeworks.basic_tasks.patterns.decorator;

class RealPrinter implements Printable {

    private final String text;

    public RealPrinter(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.print(text);
    }

}
