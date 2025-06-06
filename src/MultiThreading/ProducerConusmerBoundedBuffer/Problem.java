package MultiThreading.ProducerConusmerBoundedBuffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Problem {
    /*
    *
    * A BoundedBuffer class with ReentrantLock and two Condition objects (notFull and notEmpty)
      A simple Main method that spins up one producer and one consumer thread
      Each thread produces or consumes 10 items
    *
    *
    *
    * */

    public static void main(String[] args) throws InterruptedException {

        Buffer buffer = new Buffer();
        Thread thread1 = new Thread(() -> {
           for(int i = 0; i<10; i++) {
               buffer.produce(i);
           }
        });

        Thread thread2 = new Thread(() -> {
           for(int i = 0; i<10; i++) {
               buffer.consume();
           }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class Buffer {
    private final Queue<Integer> q = new LinkedList<>();
    private final int capacity = 5;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce(int i) {
        lock.lock();
        try {
            while (q.size() == capacity) {
                notFull.await();
            }
            q.add(i);
            System.out.println("Produced: " + i);
            notEmpty.signal();
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
            notFull.signal();
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
