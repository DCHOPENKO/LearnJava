package homeworks.basic_tasks.multi_threading.factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ProductionLine extends Thread {
    private static final String PARENT_FOLDER = "factory_products";
    private static final String SEPARATOR = "_";
    private static final String FILE_EXTENSION = ".txt";
    private final String productName;
    private final List<String> workers;
    private final Factory factory;
    private String workerName;
    private String productionStatus;
    private Path path;
    private boolean isProductionStart;

    ProductionLine(String productName, Factory factory) {
        this.productName = productName;
        this.factory = factory;
        workers = factory.getFreeWorkers();
        isProductionStart = false;
        this.start();
    }

    @Override
    public void run() {
        try {
            setWorker();
            path = Paths.get(PARENT_FOLDER,
                    productName.concat(SEPARATOR).concat(workerName).concat(FILE_EXTENSION));
            Files.createFile(path);
            isProductionStart = true;
            setProductionPhase(ProductionPhase.SURVEY, 3);
            setProductionPhase(ProductionPhase.DESIGN, 3);
            setProductionPhase(ProductionPhase.DEVELOP, 6);
            setProductionPhase(ProductionPhase.TEST, 3);
            setProductionPhase(ProductionPhase.FINISHED, 0);
            isProductionStart = false;
            synchronized (workers) {
                workers.add(workerName);
                workers.notifyAll();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private void setProductionPhase(ProductionPhase phase, int seconds) throws IOException {
        productionStatus = phase.getShortDescription();
        addDataToLogFile(productionStatus);
        spendTimeForProductionCycle(seconds);
    }

    private void addDataToLogFile(String status) throws IOException {
        if (!this.isInterrupted() && isProductionStart) {
            Files.write(path, (status + "\n").getBytes(), StandardOpenOption.APPEND);
        }
    }

    private void spendTimeForProductionCycle(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            this.interrupt();
        }
    }

    private void setWorker() throws InterruptedException {
        synchronized (workers) {
            while (workers.isEmpty()) {
                productionStatus = "All workers busy. Waiting while somebody will be released (not started)";
                workers.wait();
            }
            workerName = workers.get(0);
            workers.remove(0);
        }
    }

    public void showStatus() {
        System.out.println(productionStatus);
    }

    public void cancelProduction(String text) throws IOException {
        if (isProductionStart) {
            addDataToLogFile(text);
            this.interrupt();
        }
    }

}
