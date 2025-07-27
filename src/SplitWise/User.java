package SplitWise;

public class User {
    private int id;
    private String name;
    private BalanceSheet balanceSheet;

    public User(int id, String name, BalanceSheet balanceSheet) {
        this.id = id;
        this.name = name;
        this.balanceSheet = balanceSheet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }
}
