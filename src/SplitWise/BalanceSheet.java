package SplitWise;

import java.util.Map;

public class BalanceSheet {
    private int balanceSheetId;
    private double totalOwe;
    private double totalGet;
    private double totalSpent;
    /*
    1️⃣ Map<Integer, Balance> (User ID as key)
    This is more common in MAANG interviews for real-world designs.
    Why?

    In real systems, the User object is often large and comes from a database or service — you don’t want to keep full
    user objects in every map just for lookup.

    IDs are immutable and lightweight — no risk of equals()/hashCode() breaking.

    Easy to serialize or store in distributed caches (e.g., Redis, Memcached).

    Plays well in distributed systems, where different services only know the user’s ID and not the entire object.
     */
    // We can also take a double if it is positive it means we take amount from user else we need to give
    private Map<Long, Double> userBalance;

    public BalanceSheet() {
    }

    public int getBalanceSheetId() {
        return balanceSheetId;
    }

    public void setBalanceSheetId(int balanceSheetId) {
        this.balanceSheetId = balanceSheetId;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalGet() {
        return totalGet;
    }

    public void setTotalGet(double totalGet) {
        this.totalGet = totalGet;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public Map<Long, Double> getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Map<Long, Double> userBalance) {
        this.userBalance = userBalance;
    }
}
