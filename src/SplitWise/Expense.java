package SplitWise;

import java.util.List;

public class Expense {
    private int id;
    private User paidUser;
    private String description;
    private double amount;
    private  List<SplitWise.Split> participants;
    private SplitType splitType;
    private int groupId;

    public Expense(int groupId, String description, User paidUser, double amount, List<SplitWise.Split> participants, SplitType splitType) {
        this.groupId = groupId;
        this.paidUser = paidUser;
        this.amount = amount;
        this.participants = participants;
        this.splitType = splitType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(User paidUser) {
        this.paidUser = paidUser;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Split> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Split> participants) {
        this.participants = participants;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }
}
