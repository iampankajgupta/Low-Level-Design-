package MultiThreading.MonitorLock;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ShareResourceProducerConsumerQueue {
    Queue<Integer> queue;
    int bufferSize;

    public ShareResourceProducerConsumerQueue(int bufferSize) {
        this.bufferSize = bufferSize;
        this.queue = new ArrayDeque<>(bufferSize);
    }

    public synchronized void produceItem(Integer item) {
        System.out.println(Thread.currentThread().getName() + ": Inside produce item");
        while(queue.size() == bufferSize) {
            try {
                wait();
            }catch (InterruptedException interruptedException) {

            }
        }

        System.out.println(Thread.currentThread().getName() + ": Producing item: "+item);
        queue.add(item);
        notify();
    }

    public synchronized void consumeItem() {
        System.out.println(Thread.currentThread().getName() + ": Inside consume item");
        while(queue.isEmpty()) {
            try {
                wait();
            }catch (InterruptedException interruptedException) {

            }
        }
        int peek = queue.poll();
        System.out.println(Thread.currentThread().getName() + ": Consuming item: "+peek);
        notify();
    }

    public static void main(String[] args) {
        ShareResourceProducerConsumerQueue shareResourceProducerConsumerQueue = new ShareResourceProducerConsumerQueue(5);
        Thread thread1 = new Thread(() -> {
           for(int i = 1; i<=10; i++) {
               shareResourceProducerConsumerQueue.produceItem(i);
           }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 1; i<=10; i++) {
                shareResourceProducerConsumerQueue.consumeItem();
            }
        });

        thread1.start();
        thread2.start();
    }
}
