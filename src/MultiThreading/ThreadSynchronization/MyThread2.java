package MultiThreading.ThreadSynchronization;

import MultiThreading.MyThread;

public class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World....");
    }

    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        Thread thread = new Thread(myThread);
        thread.start();

    }
}
