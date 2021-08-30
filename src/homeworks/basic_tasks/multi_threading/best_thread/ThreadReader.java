package homeworks.basic_tasks.multi_threading.best_thread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ThreadReader extends Thread {
    private static final String PATH = "source_for_best_thread/Story.txt";
    private static final String REGEX = "[-.?!)(,:]";
    private static final String WORD = "holidays";
    private final String shortName;
    private int counter;
    private long timeLive;

    ThreadReader(String shortName) {
        this.shortName = shortName;
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public Long getTimeLive() {
        return timeLive;
    }

    public String getShortName() {
        return shortName;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            List<String> strings = Files.readAllLines(Paths.get(PATH));
            for (String str : strings) {
                String[] words = str.toLowerCase().replaceAll(REGEX, "").split("\\s");
                counter += (int) Arrays.stream(words)
                        .filter(s -> s.equals(WORD))
                        .count();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeLive = System.currentTimeMillis() - start;
        System.out.println(shortName + "  " + timeLive);
    }
}
