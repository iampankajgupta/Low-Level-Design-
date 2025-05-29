package MultiThreading.ShareResource;

import java.util.concurrent.atomic.AtomicInteger;

public class Problem2 {

    /*
    *   Bonus Challenge (Level Up):
        Use 3 threads:

        Thread 1 deposits ₹1000 ten times

        Thread 2 withdraws ₹500 ten times

        Thread 3 checks balance 10 times in between
        This introduces readers and writers, which can later lead to:
        ReadWriteLock
        volatile
        ThreadLocal
    *
    *
    *
    * */
    public static void main(String[] args) throws InterruptedException {
        BankAccount2 account2 = new BankAccount2();
        Thread thread1 = new Thread(() -> {
            for(int i = 1; i<=10; i++) {
                account2.deposit(1000);
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 1; i<=10; i++) {
                account2.withDraw(500);
            }
        });

        Thread thread3 = new Thread(() -> {
            for(int i = 1; i<=10; i++) {
                account2.printBalance();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();


        /*
        *   Because of thread interleaving:
            The printBalance() thread may run between or after deposits/withdrawals.
            The CPU decides the exact execution timing, and it's not deterministic.
            synchronized ensures atomicity, not ordering or even spread of thread runs.
            *
        * */

        /*
        * 🧠 LLD Interview Insight
            1. synchronized ensures mutual exclusion (1 thread at a time), but not execution order.
            2. Thread output varies run to run — that’s normal and interviewers want to know if you understand that.
            3. If exact sequencing is needed, then we use wait()/notify(), Semaphore, CountDownLatch, etc.
        *
        * */

        /*
        * 🤔 Why Synchronize printBalance()? We're just reading, right?
        Yes — printBalance() only reads the balance variable. But the key issue is:

        🔥 Visibility and Consistency
        Even reading a shared variable from multiple threads (while others are writing to it) can be problematic without synchronization.

        Here’s why:

        🧠 Java Memory Model (JMM) Rules
        When threads share variables, the Java Memory Model (JMM) says:

        If one thread writes and another thread reads the same variable, and there is no happens-before relationship (like synchronized, volatile, etc.),
        * then the reading thread might see a stale (old) value.

        That’s because:

        Threads can cache variables locally (in CPU registers or thread-local caches).

        Without synchronization, there's no guarantee the latest value is visible to other threads.

        ✅ Synchronization = Mutual Exclusion + Memory Visibility
        So when you write this:

        java
        Copy
        Edit
        public synchronized void printBalance() {
            System.out.println(balance);
        }
        *
        *
        It does two things:

        Mutual exclusion (not required for just reading — but safe).

        Memory visibility guarantee: Ensures the thread sees the latest committed value of balance.

        Even more safely (but less commonly used), you could mark balance as volatile:

        java
        Copy
        Edit
        private volatile int balance;
        This would ensure read and write visibility, but not atomicity for compound actions like balance += 1000.

        * */

    }
}

class BankAccount2 {
     private int balance = 0; // can this be made as volatile

    public synchronized void deposit(int amount) {
            balance += amount;
//          System.out.println(Thread.currentThread().getName()+"Incrementing Balance by"+ amount+"Current balance is: "+amount);
    }

    public synchronized void withDraw(int amount) {
        if(balance >= amount) {
            balance -= amount;
        }
//      System.out.println(Thread.currentThread().getName()+"Decrementing Balance by"+ amount+"left balance is: "+amount);
    }

    public synchronized void printBalance() {
        System.out.println("Current Balance is "+balance);
    }

}