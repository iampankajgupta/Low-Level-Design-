package MultiThreading.CustomPool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class main {
    public static void main(String[] args) throws InterruptedException {
        ObjectPool objectPool = new ObjectPool(3);
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i<3; i++) {
                objectPool.borrowObject();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i<3; i++) {
                objectPool.releaseObject();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }


}

class ObjectPool{
    private int count;
    private int capacity;
    private final ReentrantLock reentrantLock = new ReentrantLock();

    private Condition releaseCondition = reentrantLock.newCondition();
    private Condition borrowCondition = reentrantLock.newCondition();

    public ObjectPool(int capacity) {
        this.capacity = capacity;
        count = capacity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public void borrowObject() {
        reentrantLock.lock();
        try {
            while(count == 0) {
                borrowCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + " Borrowing Object: "+this.count);
            this.count = count - 1;
            releaseCondition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void releaseObject() {
        reentrantLock.lock();
        try {
            while(count == capacity) {
                releaseCondition.await();
            }
            System.out.println(Thread.currentThread().getName()+ " Releasing Object: "+this.count);
            this.count = count + 1;
            borrowCondition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }
}
