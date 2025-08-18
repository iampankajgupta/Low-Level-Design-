package LLD.SplitwisePractice;

import LLD.SplitWise.Group;
import SplitWise.BalanceSheet;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class User {
    private String name;
    private Long id;
    // since there is very less writes
    private List<Group> groupList = new CopyOnWriteArrayList<>();
    private BalanceSheet balanceSheet;

    public User(String name, Long id, BalanceSheet balanceSheet) {
        this.name = name;
        this.id = id;
        this.balanceSheet = balanceSheet;
    }

    public void addGroupToUser(Group group) {
        groupList.add(group);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Group> getGroupList() {
        return Collections.unmodifiableList(groupList);
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Objects.equals(name, user.name) && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
