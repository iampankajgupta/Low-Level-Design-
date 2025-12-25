package LLD.SplitWise;

import SplitWise.Balance;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
//    private static Map<String, Map<String, Double>> balanceSheet;
    private Map<String, Balance> balanceSheet;
    private double totalYourExpense;
    private double totalPayment;
    private double totalOwe;
    private double totalYourGetBack;

    UserExpenseBalanceSheet() {
        balanceSheet = new HashMap<>();
        totalYourExpense = 0;
        totalPayment = 0;
        totalYourGetBack = 0;
        totalOwe = 0;
    }

    public Map<String, Balance> getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(Map<String, Balance> balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalYourGetBack() {
        return totalYourGetBack;
    }

    public void setTotalYourGetBack(double totalYourGetBack) {
        this.totalYourGetBack = totalYourGetBack;
    }
}
