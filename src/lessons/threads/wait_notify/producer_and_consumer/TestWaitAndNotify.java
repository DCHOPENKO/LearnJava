package lessons.threads.wait_notify.producer_and_consumer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrey on 16.10.2016.
 */
public class TestWaitAndNotify {
    public static void main(String[] args) {
        List<Integer> taskQueue = new ArrayList<>();
        int MAX_CAPACITY = 5;
        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
        Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
        tProducer.start();
        tConsumer.start();
    }
}
