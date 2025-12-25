package MultiThreading;

import MultiThreading.ThreadSynchronization.MyThread2;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread running....");
    }
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(() -> myThread.run());
        thread.start();
    }
}