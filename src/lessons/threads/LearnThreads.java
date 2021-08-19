package lessons.threads;

import java.io.IOException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

public class LearnThreads {
    public static void main(String[] args) throws InterruptedException {
//        throw new NullPointerException();

        final OurThread thread = new OurThread();

//        thread.start();

        final MyRunnable runnable = new MyRunnable();

        final Thread thread1 = new Thread(runnable);

//        thread1.setDaemon(true);

        thread1.start();

        thread1.join();

        Runnable runnable1 = () -> {
            System.out.println("I'm new thread");
        };

        System.out.println("Main is finished");
    }
}

class OurThread extends Thread {
    @Override
    public void run() {
        System.out.println("I'm new thread");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
//        System.out.println("I'm new thread");
        /*while (true) {

        }*/

//        print();

//        Thread.sleep(1000);

        System.out.println("Sleeping....");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Wake up");


    }

    private void print() {
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class InnerThread implements Runnable {
    @Override
    public void run() {
        final Thread thread = Thread.currentThread();

        System.out.println("Before sleeping " + thread.isInterrupted());

      /*  try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Inside catch " + thread.isInterrupted());
            thread.interrupt();
        }*/

//        System.out.println("Inside catch " + thread.isInterrupted());


    }
}

class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        final InnerThread runnable = new InnerThread();

        final Thread thread = new Thread(runnable);

        thread.start();

//        thread.setPriority();

//        System.out.println(thread.isInterrupted());

        thread.interrupt();

//        System.out.println(Thread.interrupted());
//        System.out.println(thread.isInterrupted());

    }
}