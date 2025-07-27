package SplitWise;

public class UserBalancePair {
    private User user;
    private double amount;

    public UserBalancePair(double amount, User user) {
        this.amount = amount;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
