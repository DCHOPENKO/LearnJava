package homeworks.basic_tasks.multi_threading.best_thread;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ForTest {

    public static void main(String[] args) throws InterruptedException {

        List<ThreadReader> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            threads.add(new ThreadReader("thread " + i));
        }

        for (ThreadReader thread : threads) {
            thread.start();
            thread.join();
        }

        Thread.sleep(1000);

        Optional<ThreadReader> min = threads.stream()
                .min(Comparator.comparingLong(ThreadReader::getTimeLive));

        System.out.println("Word \"holiday\" repeated " + min.get().getCounter() + " times in provided text");
        System.out.println("The best time is " + min.get().getTimeLive() + " miliseconds");

        System.out.println("this time show next thread/s:");
        threads.stream()
                .filter(t -> t.getTimeLive().equals(min.get().getTimeLive()))
                .forEach(t -> System.out.println(t.getShortName()));


    }
}
