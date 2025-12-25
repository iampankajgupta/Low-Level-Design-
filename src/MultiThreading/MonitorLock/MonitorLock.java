package MultiThreading.MonitorLock;


public class MonitorLock{

    public synchronized void task1() {
        try {
            System.out.println("Inside task 1");
            Thread.sleep(10000);
        }catch (Exception e) {

        }

    }
    public void task2() {
        System.out.println("Inside task 2");
        synchronized (this) {
            System.out.println("task2 inside synchornized");
        }

    }
    public void task3() {
        System.out.println("task3");
    }

    public static void main(String[] args) {
        MonitorLock monitorLock = new MonitorLock();
        Thread thread = new Thread(() -> monitorLock.task1());
        Thread thread2 = new Thread(() -> monitorLock.task2());
        Thread thread3 = new Thread(() -> monitorLock.task3());

        thread.start();
        thread2.start();
        thread3.start();
    }

}
