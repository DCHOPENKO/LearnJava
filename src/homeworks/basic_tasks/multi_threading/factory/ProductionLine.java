package homeworks.basic_tasks.multi_threading.factory;

import homeworks.basic_tasks.multi_threading.factory.production_phases.Phase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductionLine extends Thread {
    private static final String PARENT_FOLDER = "factory_products";
    private static final String SEPARATOR = "_";
    private static final String FILE_EXTENSION = ".txt";
    private static final String TEXT_BEFORE_PHASE_INFO = "Current phase is ";
    private static final String PRODUCED_PRODUCT = "Production Finished. Product is ready";
    private final String PRODUCT_NAME;
    private final List<String> WORKERS;
    private final List<Phase> PHASES;
    private String workerName;
    private String productionStatus;
    private Path path;
    private boolean isProductionStart;

    ProductionLine(String productName, Factory factory) {
        this.PRODUCT_NAME = productName;
        WORKERS = factory.getFreeWorkers();
        isProductionStart = false;
        PHASES = new ArrayList<>();
        this.start();
    }

    @Override
    public void run() {
        try {
            setWorker();
            path = Paths.get(PARENT_FOLDER,
                    PRODUCT_NAME.concat(SEPARATOR).concat(workerName).concat(FILE_EXTENSION));
            Files.createFile(path);
            isProductionStart = true;
            for (Phase phase : PHASES) {
                executeProductionPhase(phase);
            }
            addDataToLogFile(PRODUCED_PRODUCT);
            isProductionStart = false;
            synchronized (WORKERS) {
                WORKERS.add(workerName);
                WORKERS.notifyAll();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public ProductionLine addProductionPhase(Phase phase) {
        PHASES.add(phase);
        return this;
    }

    private void executeProductionPhase(Phase phase) throws IOException {
        productionStatus = phase.getPhaseName();
        addDataToLogFile(TEXT_BEFORE_PHASE_INFO.concat(productionStatus));
        spendTimeForProductionCycle(phase.getProducedTime());
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
        synchronized (WORKERS) {
            while (WORKERS.isEmpty()) {
                productionStatus = "All workers busy. Waiting while somebody will be released (not started)";
                WORKERS.wait();
            }
            workerName = WORKERS.get(0);
            WORKERS.remove(0);
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
