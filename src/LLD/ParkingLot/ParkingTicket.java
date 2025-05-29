package LLD.ParkingLot;

public class ParkingTicket {
    private String id;
    private long entryTime;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private User user;
    private EntryGate entryGate;

    public ParkingTicket(String id, long entryTime, ParkingSpot parkingSpot, Vehicle vehicle, User user, EntryGate entryGate) {
        this.id = id;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.user = user;
        this.entryGate = entryGate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }
}
