package MultiThreading.ShareResource;

import java.util.concurrent.atomic.AtomicInteger;

public class Problem {

/*
*       🧪 Challenge: Bank Withdrawal
        Create a BankAccount class shared between two threads:

        One thread deposits ₹1000 ten times
        Another thread withdraws ₹500 ten times

        Ensure:
        Balance never goes negative
        Both operations are thread-safe
*
* */


    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();

        Thread thread1 = new Thread(() -> {
            for(int i = 1; i<=10; i++) {
               bankAccount.deposit();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 1; i<=10; i++) {
                bankAccount.withDraw();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(bankAccount.balance);

    }





}
class BankAccount {
    int balance = 0;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void deposit() {
        synchronized (this) {
            balance += 1000;
        }
        atomicInteger.getAndAdd(1000);
    }

//    public void depositUsingAtomicInteger() {
//        balance += 1000;
//        atomicInteger.getAndAdd(1000);
//    }
    public void withDraw() {
        synchronized (this) {
            if(balance >= 500) {
                balance -= 500;
            }
        }
    }

    public void withDrawUsingAtomicInteger() {
       atomicInteger.getAndAdd(-500);
    }
}