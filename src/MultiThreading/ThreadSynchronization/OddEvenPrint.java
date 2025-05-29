package MultiThreading.ThreadSynchronization;

public class OddEvenPrint {
    public static void main(String[] args) throws InterruptedException {
        OddEvenPrinter oddEvenPrinter = new OddEvenPrinter();
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i+=2) {
                try {
                    oddEvenPrinter.oddPrinter(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 2; i <= 10; i+=2) {
                try {
                    oddEvenPrinter.evenPrinter(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class OddEvenPrinter {

    private boolean oddTurn = true;
    public synchronized void oddPrinter(int value) throws InterruptedException {
        try {
            /*
            *   This ensures that even if the thread wakes up spuriously, or if another thread changes the state, the current thread re-checks the condition before proceeding.

                🔄 It's like a retry loop:
                "I'm only allowed to run if it's my turn. If I wake up, I'll check again. If still not my turn, I wait again."
            *
            * */
            while (!oddTurn) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " Printing Odd Number: " + value);
            // jaise hi odd mila ab lets print even number i.e odd is false;
            oddTurn = false;
            notify();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void evenPrinter(int value) throws InterruptedException {
        try {
            while (oddTurn) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " Printing Even Number: " + value);
            oddTurn = true;
            notify();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
