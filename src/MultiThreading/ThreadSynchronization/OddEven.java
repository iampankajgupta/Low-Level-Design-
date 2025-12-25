package MultiThreading.ThreadSynchronization;

import java.util.concurrent.Semaphore;

public class OddEven {
    private int max = 10;
    private int start = 1;
    private final Semaphore sem1 = new Semaphore(1);
    private final Semaphore sem2 = new Semaphore(0);
    private final Semaphore sem3 = new Semaphore(0);

    public void printOdd() {
        while(start <= max) {
            try {
                sem1.acquire();
                if(start <=max) {
                    System.out.println(Thread.currentThread().getName()+" : "+start++);
                }
                sem2.release();
            }catch (InterruptedException e) {

            }
        }
    }

    public void printEven() {
        while(start <=max) {
            try {
                sem2.acquire();
                if(start <=max) {
                    System.out.println(Thread.currentThread().getName()+" : "+start++);
                }
                sem3.release();
            }catch (InterruptedException e) {

            }
        }
    }

    public void printOdd2() {
        while(start <=max) {
            try {
                sem3.acquire();
                if(start <=max) {
                    System.out.println(Thread.currentThread().getName()+" : "+start++);
                }
                sem1.release();
            }catch (InterruptedException e) {

            }
        }
    }


    public static void main(String[] args) {
        OddEven oddEven = new OddEven();
        new Thread(() -> oddEven.printOdd()).start();
        new Thread(() -> oddEven.printEven()).start();
        new Thread(() -> oddEven.printOdd2()).start();

    }
}
