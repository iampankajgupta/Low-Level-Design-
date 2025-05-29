package MultiThreading.ShareResource;

import java.util.concurrent.atomic.AtomicInteger;

public class ShareResourceSync {
//    Phase 2 – Shared Resources & Synchronization
//    🧠 Problem in Multithreading:
//    When multiple threads modify the same data, race conditions can happen.
//
//            🚨 Example Problem:
//    Suppose two threads increment a shared counter 1000 times each. You expect the result to be 2000, but you might get something less due to race conditions.


    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
           for(int i = 1;i<=1000; i++) {
               counter.incrementCountByAtomicInteger();
               counter.incrementCount();
           }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 1;i<=1000; i++) {
                counter.incrementCountByAtomicInteger();
                counter.incrementCount();
            }
        });

        thread1.start();
        thread2.start();

        // if we comment this thread it will quite possible that main thread end output prints as 0
//        thread.join();
//        thread2.join();
//
        // this is to tell main thread wait for thread1 and thread2 to stop and then only you stop and terminate
        thread1.join();
        thread2.join();

        // Expected it 2000 but due to race condition might not get that
        System.out.println(counter.count);


        // to fix this issue we can make increment method as synchronised
        // Or can also use synchronise block
        // also can make count as Atomic Integer

        /*
        * 🧠 Interview Insight:
            Synchronizing a whole method is simple but can reduce concurrency.
            Using a synchronized block gives finer control, improves performance in bigger methods.
        *
        * */

        System.out.println(counter.atomicInteger);

        /*
        * 🔹 AtomicInteger internally uses CAS (Compare-And-Swap), offering thread safety without locking.
        🔸 It’s faster than synchronized in many cases.
        *
        * */
    }
}

class Counter {
    int count = 0;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void incrementCount(){
        count++;
    }

    public void incrementCountByAtomicInteger(){
        atomicInteger.getAndIncrement();
    }
}


// Problem

