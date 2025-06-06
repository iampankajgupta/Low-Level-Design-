package LLD.SplitWise;

import java.util.List;
import java.util.UUID;

public class Expense {
    private String expenseId;
    private String description;
    private ExpenseType expenseType;
    private double amount;
    private User paidUser;
    private List<Split> friendList;

    public Expense(String description, ExpenseType expenseType, double amount, User paidUser, List<Split> friendList) {
        this.expenseId = UUID.randomUUID().toString();
        this.description = description;
        this.expenseType = expenseType;
        this.amount = amount;
        this.paidUser = paidUser;
        this.friendList = friendList;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(User paidUser) {
        this.paidUser = paidUser;
    }

    public List<Split> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Split> friendList) {
        this.friendList = friendList;
    }
}
