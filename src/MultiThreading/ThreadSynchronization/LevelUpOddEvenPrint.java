package MultiThreading.ThreadSynchronization;

public class LevelUpOddEvenPrint {
    public static void main(String[] args) throws InterruptedException {

        /*
        *       🔄 Problem Statement:
                Create a program where three threads print numbers in sequence like this:

                csharp
                Copy
                Edit
                Thread A → prints numbers divisible by 3 (e.g., 3, 6, 9...)
                Thread B → prints numbers divisible by 3 with remainder 1 (e.g., 1, 4, 7...)
                Thread C → prints numbers divisible by 3 with remainder 2 (e.g., 2, 5, 8...)
                📈 Target Output for numbers 1 to 10:
                mathematica
                Copy
                Edit
                Thread B: 1
                Thread C: 2
                Thread A: 3
                Thread B: 4
                Thread C: 5
                Thread A: 6
                Thread B: 7
                Thread C: 8
                Thread A: 9
                Thread B: 10
        *
        * */

        // Main learning from this problem was notifiy() invokes only single thread while notify invokes multiple waiting threads
        // i.e used notifyAll()

        Printer printer = new Printer();
        Thread thread1 = new Thread(() -> {
            for(int i = 3; i<=10; i+=3) {
                try {
                    printer.exactDivisible();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 1; i<=10; i+=3) {
                try {
                    printer.remainderOne();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            for(int i = 2; i<=10; i+=3) {
                try {
                    printer.remainderTwo();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

    }
}
class Printer {
    public int counter = 1;
    private boolean remainderOne = true;
    private boolean exactDivisible = false;
    private boolean remainderTwo = false;


    public synchronized void remainderOne() throws InterruptedException {
        while(!remainderOne) {
            wait();
        }
        if(counter > 10){
            notifyAll();
            return;
        } 
        System.out.println(Thread.currentThread().getName()  + "B Printing Remainder One: "+counter);
        counter = counter + 1;
        if(counter % 3 == 0) {
            exactDivisible = true;
        }else {
            remainderTwo = true;
        }
        remainderOne = false;
        notifyAll();
    }
    public synchronized void remainderTwo() throws InterruptedException {

        while(!remainderTwo) {
            wait();
        }
        if(counter > 10){
            notifyAll();
            return;
        }
        System.out.println(Thread.currentThread().getName() + "C Printing Remainder Two: "+counter);
        counter = counter + 1;
        remainderTwo = false;
        if(counter % 3 == 0) {
            exactDivisible = true;
        }else {
            remainderOne = true;
        }
        notifyAll();
    }
    public synchronized void exactDivisible() throws InterruptedException {
        while(!exactDivisible) {
            wait();
        }
        if(counter > 10){
            notifyAll();
            return;
        }
        System.out.println(Thread.currentThread().getName() + "A Printing Exactly Divisible: "+counter);
        counter = counter + 1;
        exactDivisible = false;
        if(counter % 3 == 1) {
            remainderOne = true;
        }else {
            remainderTwo = true;
        }
        notifyAll();

    }
}