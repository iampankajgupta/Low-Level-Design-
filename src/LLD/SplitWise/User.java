package LLD.SplitWise;

public class User {
    private String userId;
    private String name;
    private UserExpenseBalanceSheet balanceSheet;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserExpenseBalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(UserExpenseBalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }
}
