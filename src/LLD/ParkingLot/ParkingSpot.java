package LLD.ParkingLot;

import LLD.ParkingLot.enums.SlotType;

public class ParkingSpot {
    private int id;
    private boolean isAvailable;
    private SlotType slotType;
    private float price;

    public ParkingSpot(int id, boolean isAvailable, SlotType slotType, float price) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.slotType = slotType;
        this.price = price;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
