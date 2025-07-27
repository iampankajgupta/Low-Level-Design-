package DesighPatterns.StateDesignPattern.VendingMachine;

import java.util.List;

public class Shelf {
    private List<Item> itemList;
    private String shelfId;

    public Shelf(List<Item> itemList, String shelfId) {
        this.itemList = itemList;
        this.shelfId = shelfId;
    }


    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getShelfId() {
        return shelfId;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }
}
