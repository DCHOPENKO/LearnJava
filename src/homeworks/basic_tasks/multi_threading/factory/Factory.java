package homeworks.basic_tasks.multi_threading.factory;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private final List<String> freeWorkers = new ArrayList<>();

    Factory() {
        freeWorkers.add("Vasya");
        freeWorkers.add("Petya");
    }

    public List<String> getFreeWorkers() {
        return freeWorkers;
    }

    public void addWorker (String name) {
        synchronized (freeWorkers) {
            freeWorkers.add(name);
            freeWorkers.notifyAll();
        }
    }

}
