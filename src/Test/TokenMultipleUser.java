package Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TokenMultipleUser {
    private int capacity;
    private long refillRate;
    //
    private ConcurrentHashMap<Integer, TokenRateLimiter> users = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, ReentrantLock> reentrantLockConcurrentHashMap = new ConcurrentHashMap<>();

    public TokenMultipleUser(int capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    public boolean allow(int userId) {
        ReentrantLock lock = reentrantLockConcurrentHashMap.computeIfAbsent(userId, k -> new ReentrantLock());
        lock.lock();
        try {
            TokenRateLimiter tokenRateLimiter = users.computeIfAbsent(userId , k -> new TokenRateLimiter(capacity, refillRate));
            boolean allow = tokenRateLimiter.allow();
            System.out.println(allow);
            return allow;
        }finally {
            lock.unlock();
        }

    }
}
