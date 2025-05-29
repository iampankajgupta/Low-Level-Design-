package MultiThreading;

public class Test {

//    Method	             Code Style	         Reusability	Verbose
//    Implements Runnable	✅ Clean, flexible	        ✅ Yes Medium
//    Extends Thread	👎 Limited (single inheritance)	❌ No	Medium
//    Anonymous inner class	👌 Good for one-time tasks	❌ No	Slight
//    Lambda	✅ Cleanest for simple tasks	        ❌ No	✅ Minimal
//    Anonymous Thread extension	🚫 Not recommended	❌ No	Noisy

    public static void main(String[] args) {

        Thread threadA = new Thread(new MyRunnable(1,5, "Thread A"));
        Thread threadB = new Thread(new MyRunnable(6,10, "Thread B"));
        threadA.start();
        threadB.start();


        // Using Lambda Expression
//        ➡️ This is the cleanest and most common modern style for short tasks.

        Thread t = new Thread(() -> {
            System.out.println("Hello from lambda");
        });
        t.start();

        // Using Anonymous inner class

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Using Anonymous inner class");
            }
        });


    }
}

// Using implementing Runnable

class MyRunnable implements Runnable {
    private int start;
    private int end;
    private String threadName;

    public MyRunnable(int start, int end, String threadName) {
        this.start = start;
        this.end = end;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for(int i = start; i<=end; i++) {
            System.out.println(threadName+":"+i);
        }
    }
}

// Not very useful because multiple inheritance is not allowed in java
class test2 extends Thread {
    @Override
    public void run(){
        System.out.println("Hello from thread!!!!!!!");
    }

}