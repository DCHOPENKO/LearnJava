package lessons;

public class LowCouplingCode {
    public static void main(String[] args) {

    }
}

class Action {
    private One one;
    private Two two;

    public Action(One one, Two two) {
        this.one = one;
        this.two = two;
    }

    public void action() {
        one.print();
    }
}

class ActionNew {
    private Printable printable;

    public ActionNew(Printable printable) {
        this.printable = printable;
    }

    public void action() {
        printable.print();
    }
}

interface Printable {
    void print();
}

class One implements Printable {
    public void print() {
        System.out.println("One");
    }
}

class Two implements Printable {
    public void print() {
        System.out.println("Two");
    }
}
