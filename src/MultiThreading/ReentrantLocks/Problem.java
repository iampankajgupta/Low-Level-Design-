package MultiThreading.ReentrantLocks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Problem {
    /*
    * Imagine a shared resource (e.g., seat reservation system). Multiple threads try to book seats.
    * Use ReentrantLock with tryLock to allow threads to retry or fallback if the lock isn’t immediately available.
    * */

    /*
    * ReentrantLock is part of java.util.concurrent.locks package.
    It:
    Provides more control over locking than synchronized

    Supports features like:

    Try-locking
    Timeout-based locking
    Interruptible locks
    Fairness policy

    🔁 "Reentrant" means: The same thread can acquire the lock multiple times without getting blocked.
    *
    * More details can be found in OneNote
    * */

    public static void main(String[] args) {
        List<Seat> seatList = new ArrayList<>();
        Seat seat1 = new Seat("1", true);
        Seat seat2 = new Seat("2", true);
        seatList.add(seat1);
        seatList.add(seat2);
        SeatReservationSystem seatReservationSystem = new SeatReservationSystem(seatList);
        Thread thread1 = new Thread(() -> {

           Seat seat3 = seatReservationSystem.bookSeat("1");
           if(seat3 != null) {
               System.out.println("Thread A Booking Confirmed for Seat: "+seat3.getSeadId());
           }else {
               System.out.println("Seat Already Booked");
           }
        });

        Thread thread2 = new Thread(() -> {
            Seat seat3 = seatReservationSystem.bookSeat("1");
            if(seat3 != null) {
                System.out.println("Thread B Booking Confirmed for Seat: "+seat3.getSeadId());
            }else {
                System.out.println("Seat Already Booked");
            }
        });

        thread1.start();
        thread2.start();
    }
}

class SeatReservationSystem {
    List<Seat> seatList;

    // Used ReentrantLock also provide retry mechanism if the thread is unavailable
    // also provide sequencing of thread like queue of thread sequence will be followed
    ReentrantLock lock = new ReentrantLock();

    public SeatReservationSystem(List<Seat> seatList) {
        this.seatList = seatList;
    }

    // Also implemented RetryLock before retrying
    public Seat bookSeat(String seatId) {
        int retries = 3;
        while (retries-- > 0) {
            if (lock.tryLock()) {
                try {
                    for (Seat seat : seatList) {
                        if (seat.getSeadId().equals(seatId) && seat.isAvailable()) {
                            seat.setAvailable(false);
                            return seat;
                        }
                    }
                    return null;
                } finally {
                    lock.unlock();
                }
            } else {
                try {
                    Thread.sleep(100); // small wait before retrying
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return null;
    }
}

class Seat {
    private String seadId;
    private boolean isAvailable;

    public Seat(String seadId, boolean isAvailable) {
        this.seadId = seadId;
        this.isAvailable = isAvailable;
    }

    public String getSeadId() {
        return seadId;
    }

    public void setSeadId(String seadId) {
        this.seadId = seadId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}