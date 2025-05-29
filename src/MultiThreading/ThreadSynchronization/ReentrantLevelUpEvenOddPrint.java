package MultiThreading.ThreadSynchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLevelUpEvenOddPrint {
    public static void main(String[] args) throws InterruptedException {

        Printer2 printer = new Printer2();
        Thread thread1 = new Thread(() -> {
            for(int i = 3; i<=10; i+=3) {
                try {
                    printer.exactDivisible();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 1; i<=10; i+=3) {
                try {
                    printer.remainderOne();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            for(int i = 2; i<=10; i+=3) {
                try {
                    printer.remainderTwo();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();



    }
}

class Printer2 {
    public int counter = 1;
    private boolean remainderOne = true;
    private boolean exactDivisible = false;
    private boolean remainderTwo = false;
    Lock lock = new ReentrantLock();
    // here we were sure about the conditions i.e created three conditions
    Condition divisible = lock.newCondition();
    Condition remainderTwoCondition = lock.newCondition();
    Condition remainderOneCondition = lock.newCondition();


    public void remainderOne() throws InterruptedException {
        lock.lock();
        try {
            while (!remainderOne) {
                remainderOneCondition.await();
            }
            if (counter > 10) {
                remainderOneCondition.signalAll();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "B Printing Remainder One: " + counter);
            counter = counter + 1;
            if (counter % 3 == 0) {
                exactDivisible = true;
                divisible.signal();
            } else {
                remainderTwo = true;
                remainderTwoCondition.signal();
            }
            remainderOne = false;
            remainderOneCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void remainderTwo() throws InterruptedException {
        lock.lock();
        try {
            while (!remainderTwo) {
                remainderTwoCondition.await();
            }
            if (counter > 10) {
                remainderTwoCondition.signalAll();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "C Printing Remainder Two: " + counter);
            counter = counter + 1;
            remainderTwo = false;
            if (counter % 3 == 0) {
                exactDivisible = true;
            } else {
                remainderOne = true;
            }
            remainderTwoCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void exactDivisible() throws InterruptedException {
        lock.lock();
        try {
            while (!exactDivisible) {
                divisible.await();
            }
            if (counter > 10) {
                divisible.signalAll();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "A Printing Exactly Divisible: " + counter);
            counter = counter + 1;
            exactDivisible = false;
            if (counter % 3 == 1) {
                remainderOne = true;
            } else {
                remainderTwo = true;
            }
            divisible.signalAll();
        }finally {
            lock.unlock();
        }

    }
}
