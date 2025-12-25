package Test;

public class TokenRateLimiter {
    // token rate limiter
    // it has a capacity and at fixed interval of time token will be added

    private double tokens;
    private long capacity;
    private long refillRate; // specific internal of time let's say every 2 sec
    private long lastRefillTime;

    public TokenRateLimiter(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        tokens = capacity;
        lastRefillTime = System.currentTimeMillis();
    }

    boolean allow() {
        /// before doing that refill
        refill();
        if(tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long elapsed = now - lastRefillTime;

        if (elapsed <= 0) return;

        double tokensToAdd = (elapsed / 1000.0) * refillRate;
        tokens = Math.min(capacity, tokens + tokensToAdd);

        lastRefillTime = now;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenRateLimiter limiter = new TokenRateLimiter(5, 1); // 1 token/sec

        for (int i = 0; i < 10; i++) {
            System.out.println("Allowed: " + limiter.allow() + " | Tokens left: " + limiter.tokens);
            Thread.sleep(1000);
        }
    }
}
