package MultiThreading.ProducerConusmerBoundedBuffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultipleProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        Buffer2 buffer = new Buffer2();
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i<5; i++) {
                buffer.produce(i);
            }
        });

        Thread thread3 = new Thread(() -> {
            for(int i = 0; i<5; i++) {
                buffer.produce(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i<5; i++) {
                buffer.consume();
            }
        });

        Thread thread4 = new Thread(() -> {
            for(int i = 0; i<5; i++) {
                buffer.consume();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }

}


class Buffer2 {
    private final Queue<Integer> q = new LinkedList<>();
    private final int capacity = 5;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    /*
    * 🧠 Why signalAll() Matters Here
        In a multi-threaded scenario:

        If multiple producer threads are waiting and only one is signaled (using signal()), it may not proceed if conditions still don’t satisfy.

        signalAll() wakes up all waiting threads, and only those whose condition passes will proceed.

        This avoids potential deadlocks or missed signals, especially in complex interactions between producers and consumers.
    *
    *
    * */

    public void produce(int i) {
        lock.lock();
        try {
            while (q.size() == capacity) {
                notFull.await();
            }
            q.add(i);
            System.out.println("Produced: " + i);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public int consume() {
        lock.lock();
        try {
            while (q.isEmpty()) {
                notEmpty.await();
            }
            int item = q.poll();
            System.out.println("Consumed: " + item);
            notFull.signalAll();
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}