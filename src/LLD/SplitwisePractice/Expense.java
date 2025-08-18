package LLD.SplitwisePractice;

import SplitWise.SplitType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Expense {
    private Long id;
    private String description;
    private String name;
    private List<User> userList;
    private User paidUser;
    private SplitType splitType;
    private LocalDate localDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(User paidUser) {
        this.paidUser = paidUser;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
