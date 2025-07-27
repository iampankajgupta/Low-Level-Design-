package LLD.ElevtorDesign.ElevatorDesignEnhanced;

import java.util.List;

public class Building {
    private String buildingId;
    private int noOfFloors;
    private String name;
    private String address;
    private List<Floor> floors;

    public Building(String buildingId, int noOfFloors, String name, String address, List<Floor> floors) {
        this.buildingId = buildingId;
        this.noOfFloors = noOfFloors;
        this.name = name;
        this.address = address;
        this.floors = floors;
    }

    public Building() {
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
