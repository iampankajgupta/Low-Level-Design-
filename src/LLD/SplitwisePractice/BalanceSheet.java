package LLD.SplitwisePractice;

import java.util.Map;

public class BalanceSheet {
    private Long id;
    private Double totalSpent;
    private Double totalOwe;
    private Double totalGetBack;
    private Map<User, Balance> userBalanceMap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public Double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(Double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public Double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(Double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }

    public Map<User, Balance> getUserBalanceMap() {
        return userBalanceMap;
    }

    public void setUserBalanceMap(Map<User, Balance> userBalanceMap) {
        this.userBalanceMap = userBalanceMap;
    }
}
