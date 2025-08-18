package LLD.SplitwisePractice;

import SplitWise.SplitType;

import java.util.List;
import java.util.Map;

public class SplitRequest {

    private Long id;
    private String description;
    private String name;
    /*
    // Move this field to splitDetail class
        private List<User> userList; // this will be null in case of percentage based
        private Map<User, Double> percentage; // this can be null when
     */
    private User paidUser;
    private SplitType splitType;
    private Long groupId; // 0 if it is creating a separate expense and not in group
    private Double amount;
    private SplitDetail splitDetail;


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

    public SplitDetail getSplitDetail() {
        return splitDetail;
    }

    public void setSplitDetail(SplitDetail splitDetail) {
        this.splitDetail = splitDetail;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
