package lessons.threads.wait_notify.producer_and_consumer;

import java.util.List;

/**
 * 1) Here “consume()” code has been written inside infinite loop
 * so that consumer keeps consuming elements whenever it finds something in taskQueue.
 * 2) Once the wait() is over, consumer removes an element in taskQueue and called
 * notifyAll() method. Because the last-time wait() method was called by producer thread
 * (that’s why producer is in waiting state), producer gets the notification.
 * 3) Producer thread after getting notification, if ready to produce the element
 * as per written logic.
 */
class Consumer implements Runnable {
    private final List<Integer> taskQueue;

    public Consumer(List<Integer> sharedQueue) {
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.isEmpty()) {
                System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                taskQueue.wait();
            }
            Thread.sleep(1000);
            int i = taskQueue.remove(0);
            System.out.println("Consumed: " + i);
            taskQueue.notifyAll();
        }
    }
}
