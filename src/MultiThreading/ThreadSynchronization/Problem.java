package MultiThreading.ThreadSynchronization;

public class Problem {
    public static void main(String[] args) {

        /*
        * 🧠 Why wait() and notify()?
            They help solve thread communication problems — e.g., one thread waits for a condition, and another notifies when the condition is true.
            🔑 Must-Have Rules:
    ## Must be called from within a synchronized block.
            wait() releases the monitor (lock) and suspends the thread.
            notify() (or notifyAll()) wakes up one (or all) waiting threads.
        *
            * 🚦 Real-Life Scenario: Producer-Consumer
            Let’s say:

            1. Producer puts data into a shared queue.
            2. Consumer waits if queue is empty.
        * */


        // Usecase
        // Print Even number by one thread and odd number by another thread.


    }
}

class NumberPrinter {
    private int count;

    public NumberPrinter(int count) {
        this.count = count;
    }

    
}
