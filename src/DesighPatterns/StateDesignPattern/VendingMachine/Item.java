package DesighPatterns.StateDesignPattern.VendingMachine;

public class Item {
    private String id;
    private double cost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
