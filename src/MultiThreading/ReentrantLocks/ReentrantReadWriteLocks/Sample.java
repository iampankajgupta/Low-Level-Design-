package MultiThreading.ReentrantLocks.ReentrantReadWriteLocks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Sample {
    public static void main(String[] args) {
        /*

        🔓 Step 1: ReadWriteLock
            `🔍 Problem it Solves
            Multiple readers allowed at the same time.

            Only one writer at a time.

            No reader allowed while writing.

            📘 Real-World Example
            You have a shared cache or configuration file that is read frequently but updated occasionally. You don’t want readers to block each other,
            but you also want consistency during writes.`


            ✅ Summary
            Use Case	Read Operation	Write Operation
            Cache	Lookup cache data	Refresh cache
            Config Store	Get config values	Reload config file/data

            In both, ReadWriteLock improves performance by allowing parallel reads safely.


        // When mostly read and write happens and during
                    🧵 Thread Behavior:
            ✅ Allow multiple reads simultaneously.

            ❌ Block reads during write/update to avoid inconsistency.

        *
            * ✅ What You're Doing Right
            ✔ Correct use of ReentrantReadWriteLock
            writeLock() used for deposit() and withDraw(): only one thread can modify the balance at a time.

            readLock() used for printBalance(): multiple threads can read simultaneously when no writer is active.

            🧠 Why This Is a Great LLD Pattern
            Readers-Writers problems are common in:

            Banking apps
            Caching layers
            Shared config/data store

            In your case, printBalance() could be called frequently by multiple monitoring threads (or audit systems), while deposits and withdrawals are relatively less frequent.
            This justifies using a ReadWriteLock over a regular lock.
            *
        * */
        BankAccount2 bankAccount2 = new BankAccount2();

    }
}

class BankAccount2 {
    private int balance = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void deposit(int amount) {
        lock.writeLock().lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited ₹" + amount);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void withDraw(int amount) {
        lock.writeLock().lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew ₹" + amount);
            } else {
                System.out.println(Thread.currentThread().getName() + " insufficient funds to withdraw ₹" + amount);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void printBalance() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " checked balance: ₹" + balance);
        } finally {
            lock.readLock().unlock();
        }
    }
}


