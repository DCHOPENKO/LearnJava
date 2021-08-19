package lessons.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * If you run DeadlockDemo, you will probably see only a single line of output before the application freezes.
 * To unfreeze DeadlockDemo, press Ctrl-C (assuming you are using Sun's SDK 1.4 toolkit at a Windows command prompt).
 * What causes the deadlock? Look carefully at the source code; the deposit thread must acquire two locks before
 * it can enter its innermost critical code section. The outer lock associates with the FinTrans object that
 * ft references, and the inner lock associates with the String object that anotherSharedLock references.
 * Similarly, the withdrawal thread must acquire two locks before it can enter its own innermost critical
 * code section. The outer lock associates with the String object that anotherSharedLock references, and the inner
 * lock associates with the FinTrans object that ft references. Suppose both threads' execution orders are such that
 * each thread acquires its outer lock. Thus, the deposit thread acquires its FinTrans lock, and the withdrawal thread
 * acquires its String lock. Now that both threads possess their outer locks, they are in their appropriate outer
 * critical code section. Both threads then attempt to acquire the inner locks, so they can enter the appropriate
 * inner critical code sections.
 * The deposit thread attempts to acquire the lock associated with the anotherSharedLock-referenced object.
 * However, the deposit thread must wait because the withdrawal thread holds that lock. Similarly, the withdrawal
 * thread attempts to acquire the lock associated with the ft-referenced object.
 * But the withdraw thread cannot acquire that lock because the deposit thread (which is waiting) holds it.
 * Therefore, the withdrawal thread must also wait. Neither thread can proceed because neither thread releases
 * the lock it holds. And neither thread can release the lock it holds because each thread is waiting.
 * Each thread deadlocks, and the program freezes.
 */
class DeadlockDemo {
    public static void main(String[] args) {
        FinTrans ft = new FinTrans();
        TransThread tt1 = new TransThread(ft, "Deposit Thread");
        TransThread tt2 = new TransThread(ft, "Withdrawal Thread");
        tt1.start();
        tt2.start();
    }
}

class FinTrans {
    public static String transName;
    public static double amount;
}

class TransThread extends Thread {
    private FinTrans ft;
    private static String anotherSharedLock = "";

    TransThread(FinTrans ft1, String name) {
        super(name); // Save thread's name
        ft = ft1; // Save reference to financial transaction object
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (getName().equals("Deposit Thread")) {
                synchronized (ft) {
                    synchronized (anotherSharedLock) {
                        ft.transName = "Deposit";
                        try {
                            Thread.sleep((int) (Math.random() * 1000));
                        } catch (InterruptedException e) {
                        }
                        ft.amount = 2000.0;
                        System.out.println(ft.transName + " " + ft.amount);
                    }
                }
            } else {
                synchronized (anotherSharedLock) {
                    synchronized (ft) {
                        ft.transName = "Withdrawal";
                        try {
                            Thread.sleep((int) (Math.random() * 1000));
                        } catch (InterruptedException e) {
                        }
                        ft.amount = 250.0;
                        System.out.println(ft.transName + " " + ft.amount);
                    }
                }
            }
        }
    }
}
