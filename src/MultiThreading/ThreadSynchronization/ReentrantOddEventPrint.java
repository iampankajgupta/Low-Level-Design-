package MultiThreading.ThreadSynchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantOddEventPrint {
    public static void main(String[] args) throws InterruptedException {

        OddEvenPrinter2 oddEvenPrinter = new OddEvenPrinter2();
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i+=2) {
                try {
                    oddEvenPrinter.oddPrinter(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 2; i <= 10; i+=2) {
                try {
                    oddEvenPrinter.evenPrinter(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}

class OddEvenPrinter2 {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private boolean oddTurn = true;

    public void oddPrinter(int value) throws InterruptedException {
        lock.lock();
        try {
            while (!oddTurn) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + " Printing Odd Number: " + value);
            oddTurn = false;
            condition.signalAll();  // wake up evenPrinter
        } finally {
            lock.unlock();
        }
    }

    public void evenPrinter(int value) throws InterruptedException {
        lock.lock();
        try {
            while (oddTurn) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + " Printing Even Number: " + value);
            oddTurn = true;
            condition.signalAll();  // wake up oddPrinter
        } finally {
            lock.unlock();
        }
    }
}

