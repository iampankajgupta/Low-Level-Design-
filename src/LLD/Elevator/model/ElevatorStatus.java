package LLD.Elevator.model;

import LLD.Elevator.enums.ElevatorDoorState;
import LLD.ElevtorDesign.Direction;
import java.util.Set;

public class ElevatorStatus {

    private final int id;
    private final int currentFloor;
    private final Direction direction;
    private final ElevatorDoorState elevatorDoorState;
    private final Set<Integer> pendingRequests;


    public ElevatorStatus(int id, int currentFloor, Direction direction, ElevatorDoorState elevatorDoorState, Set<Integer> pendingRequests) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.direction = direction;
        this.elevatorDoorState = elevatorDoorState;
        this.pendingRequests = pendingRequests;
    }

    @Override
    public String toString() {
        return "ElevatorStatus{" +
                "id=" + id +
                ", currentFloor=" + currentFloor +
                ", direction=" + direction +
                ", elevatorDoorState=" + elevatorDoorState +
                ", pendingRequests=" + pendingRequests +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorDoorState getElevatorDoorState() {
        return elevatorDoorState;
    }

    public Set<Integer> getPendingRequests() {
        return pendingRequests;
    }
}
