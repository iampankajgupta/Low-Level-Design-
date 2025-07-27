package LLD.ElevtorDesign;

import java.util.UUID;

public class Request {
    private String requestId;
    private int currentFloor;
    private int destination;
    private Direction direction;

    public Request(int currentFloor, int destination, Direction direction) {
        this.requestId = UUID.randomUUID().toString();
        this.currentFloor = currentFloor;
        this.destination = destination;
        this.direction = direction;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
