package LLD.Elevator.model;

public abstract class ElevatorRequest {
    protected final int floor;

    public ElevatorRequest(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }
}
