package Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;


public class RateLimiter {
    private int limit;
    private int window; // size of the window
    Map<Integer, Deque<Long>> map = new ConcurrentHashMap<>();

    RateLimiter(int limit, int window) {
     this.limit = limit;
     this.window = window;
     map = new ConcurrentHashMap<>();
    }

    boolean allow(int userId, long t) {
        Deque<Long> dq = map.computeIfAbsent(userId, k -> new ConcurrentLinkedDeque<>());

        long startTime = t - window;

        while(!dq.isEmpty() && dq.peekFirst() < startTime) {
            dq.pollFirst();
        }

        if(dq.size() < limit) {
            dq.addLast(t);
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rl = new RateLimiter(3, 10);
        int[]users = {101,102,103};

        for(int req = 0; req <5; req++) {
            for(int user : users) {
                boolean allowed = rl.allow(user, now());
                System.out.println("User " + user + " Req " + req + " -> " + allowed);
            }
            Thread.sleep(1000); // 1 second gap between request batches

        }
        System.out.println("\n=== After waiting for window to expire ===");
        Thread.sleep(11000); // wait 11 sec → window cleared

        for (int user : users) {
            boolean allowed = rl.allow(user, now());
            System.out.println("User " + user + " new request -> " + allowed);
        }
    }

    private static long now() {
        return System.currentTimeMillis() / 1000;
    }
}
