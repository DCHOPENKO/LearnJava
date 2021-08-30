package homeworks.basic_tasks.multi_threading.andrey.fabric.fabric;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public abstract class Cycle {

    public static final String NAME_DIRECTORY = "./fabric/";
    public static final String EXTENSION_TXT = ".txt";

    private String nameOfWorker;

    public Cycle(String name) {
        this.nameOfWorker = name;
    }

    public final void build() throws InterruptedException, IOException {
        writeAction("Start build " + Thread.currentThread().getName());
        createRack();
        installWheels();
        installHelm();
        installChain();
        installChairs();

    }

    public final void createRack() throws IOException, InterruptedException {
        printAndDelay("Create rack...", 1000);
    }

    public final void installWheels() throws IOException, InterruptedException {
        printAndDelay("Installing wheels", 1000);
    }

    public final void installHelm() throws IOException, InterruptedException {
        printAndDelay("Installing helm", 1000);
    }

    public final void printAndDelay(String message, long delay) throws IOException, InterruptedException {
        writeAction(message);
        Thread.sleep(delay);
    }

    protected final void writeAction(String action) throws IOException {
        Path pathToFile = Paths.get(NAME_DIRECTORY + nameOfWorker + Thread.currentThread().getName() + EXTENSION_TXT);

        Files.write(pathToFile, (LocalDateTime.now() + " " + action + "\n").getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public abstract void installChain() throws InterruptedException, IOException;

    public abstract void installChairs() throws IOException, InterruptedException;

}
