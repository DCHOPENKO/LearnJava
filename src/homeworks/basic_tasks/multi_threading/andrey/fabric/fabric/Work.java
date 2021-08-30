/*
package homeworks.basic_tasks.multi_threading.andrey.fabric.fabric;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Work implements Runnable {

    private Cycle cycle;
    private Thread thread;
    private String nameOfWorker;

    public Work(Cycle cycle, String nameOfWorker) {
        this.cycle = cycle;
        this.nameOfWorker = nameOfWorker;
        thread = new Thread(this, nameOfWorker);
        thread.start();
    }


    @Override
    public void run() {
        try {
            cycle.build();
        } catch (InterruptedException | IOException e) {
            thread.interrupt();
            try {
                Path pathToFile = Paths.get(NAME_DIRECTORY + nameOfWorker + EXTENSION_TXT);

                Files.write(pathToFile, ("Worker with name " + thread.getName() + " interrupt working").getBytes(),
                        StandardOpenOption.APPEND);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void stopWork() {
        thread.interrupt();
    }

}
*/
