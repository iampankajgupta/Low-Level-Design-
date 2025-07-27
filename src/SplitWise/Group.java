package SplitWise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Group {
    private int groupId;
    private String groupName;
    private String groupDescription;
    private List<User> userList;
    private List<Expense> expenseList;
    private Map<Integer,List<UserBalancePair>> oweBalanceSheet;
    private Map<Integer, List<UserBalancePair>> takeBalanceSheet;
    private boolean isAllBalanceSettled;

    public Group(int groupId, String groupName, String groupDescription, List<User> userList, List<Expense> expenseList, boolean isAllBalanceSettled) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.userList = userList;
        this.expenseList = expenseList;
        this.oweBalanceSheet = new ConcurrentHashMap<>();
        this.takeBalanceSheet = new ConcurrentHashMap<>();
        this.isAllBalanceSettled = isAllBalanceSettled;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }
    public boolean isAllBalanceSettled() {
        return isAllBalanceSettled;
    }

    public void setAllBalanceSettled(boolean allBalanceSettled) {
        isAllBalanceSettled = allBalanceSettled;
    }

    public Map<Integer, List<UserBalancePair>> getOweBalanceSheet() {
        return oweBalanceSheet;
    }

    public void setOweBalanceSheet(Map<Integer, List<UserBalancePair>> oweBalanceSheet) {
        this.oweBalanceSheet = oweBalanceSheet;
    }

    public Map<Integer, List<UserBalancePair>> getTakeBalanceSheet() {
        return takeBalanceSheet;
    }

    public void setTakeBalanceSheet(Map<Integer, List<UserBalancePair>> takeBalanceSheet) {
        this.takeBalanceSheet = takeBalanceSheet;
    }
}