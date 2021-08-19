package lessons.threads.wait_notify.producer_and_consumer;

import java.util.List;

/**
 * http://howtodoinjava.com/core-java/multi-threading/how-to-work-with-wait-notify-and-notifyall-in-java/
 * 1) Here “produce(counter++)” code has been written inside infinite loop so that producer
 * keeps producing elements at regular interval.
 * 2) We have written the produce() method code following the general guideline to write wait()
 * method as mentioned in first section.
 * 3) Once the wait() is over, producer add an element in taskQueue and called notifyAll()
 * method. Because the last-time wait() method was called by consumer thread (that’s why producer
 * is out of waiting state), consumer gets the notification.
 * 4) Consumer thread after getting notification, if ready to consume the element as per written logic.
 * 5) Note that both threads use sleep() methods as well for simulating time delays
 * in creating and consuming elements.
 */
class Producer implements Runnable {
    private final List<Integer> taskQueue;
    private final int MAX_CAPACITY;

    public Producer(List<Integer> sharedQueue, int size) {
        this.taskQueue = sharedQueue;
        this.MAX_CAPACITY = size;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                produce(counter++);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.size() == MAX_CAPACITY) {
                System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                taskQueue.wait();
            }

            Thread.sleep(1000);
            taskQueue.add(i);
            System.out.println("Produced: " + i);
            taskQueue.notifyAll();
        }
    }
}
