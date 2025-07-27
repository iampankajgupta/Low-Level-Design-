package SplitWise;

import java.util.Map;

public class BalanceSheet {
    private int balanceSheetId;
    private double totalOwe;
    private double totalGet;
    private double totalSpent;
    private Map<Integer, Balance> userBalance;

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

    public Map<Integer, Balance> getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Map<Integer, Balance> userBalance) {
        this.userBalance = userBalance;
    }
}
