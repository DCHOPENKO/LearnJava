package homeworks.basic_tasks.multi_threading.andrey.fabric.fabric;

import java.io.IOException;

public class Bicycle extends Cycle {

    public Bicycle(String name) {
        super(name);
    }

    @Override
    public void installChain() throws IOException, InterruptedException {
        printAndDelay("Install chain on bike", 8000);
    }

    @Override
    public void installChairs() throws IOException, InterruptedException {
        printAndDelay("Install chair on bike", 7000);
    }
}

class Scooter extends Cycle {

    public Scooter() {
        super(Scooter.class.getSimpleName());
    }

    @Override
    public void installChain() throws IOException, InterruptedException {
        printAndDelay("Install chain on scooter", 1000);
    }

    @Override
    public void installChairs() throws IOException, InterruptedException {
        printAndDelay("Install chairs on scooter", 1000);
    }

}

class Car extends Cycle {

    public Car() {
        super(Cycle.class.getSimpleName());
    }

    @Override
    public void installChain() throws IOException, InterruptedException {
        printAndDelay("Install chain on car...", 1000);
    }

    @Override
    public void installChairs() throws IOException, InterruptedException {
        printAndDelay("Install chair on car...", 1000);
    }

}
