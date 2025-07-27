package LLD.Elevator.model;

import LLD.Elevator.enums.ElevatorDoorState;
import LLD.ElevtorDesign.Direction;
import LLD.ElevtorDesign.Status;

import java.util.Set;
import java.util.TreeSet;

public class Elevator {
    public final int id;
    private final int maxFloor;
    private final int minFloor;
    private Direction direction;
    private Status status;
    private ElevatorDoorState elevatorDoorState;
    private TreeSet<Integer> insideRequests;
//    private final NavigableSet<Integer> insideRequests = new ConcurrentSkipListSet<>(); // for MultiThreaded Environment
    private int currentFloor;
    private Boolean isOdd;

    public Elevator(int id, int minFloor, int maxFloor, Boolean isOdd) {
        this.id = id;
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
        this.insideRequests = new TreeSet<>();
        this.direction = Direction.IDLE;
        this.elevatorDoorState = ElevatorDoorState.OPEN;
        this.status = Status.WORKING;
        this.isOdd = isOdd;

    }


    // handleInternalRequest(int floor)
    // move
    // openDoor closeDoor()

    public void addExternalRequest(int floor) {
        addInternalRequest(floor, false);
    }


    public void addInternalRequest(int floor, boolean isInternal) {
        if (floor >= minFloor && floor <= maxFloor) {
            insideRequests.add(floor);

            if(direction == Direction.IDLE) {
                if(floor > currentFloor) {
                    direction = Direction.UP;
                }else if(floor < currentFloor) {
                    direction = Direction.DOWN;
                }
            }

            if(isInternal) {
                System.out.println("📥 Elevator " + id + " received INSIDE request to floor " + floor);
            }else {
                System.out.println("📤 Elevator " + id + " received EXTERNAL assignment to floor " + floor);
            }
        }
        else {
            System.out.println("⚠️ Invalid floor " + floor + " ignored by Elevator " + id);
        }
    }

    // this logic can be move to somewhere else moving logic can be changed based on the Algo
    // Moved the logi

    public void move() {

        if (insideRequests.isEmpty()) {
            elevatorDoorState = ElevatorDoorState.IDLE;
            if(currentFloor != 0) {
                currentFloor--;
                direction = Direction.DOWN;
            }else {
                direction = Direction.IDLE;
            }
            return;
        }

        int targetFloor = direction.equals(Direction.DOWN) ? insideRequests.first() : insideRequests.last();

        if (currentFloor < targetFloor) {
            direction = Direction.UP;
            currentFloor++;
        } else if (currentFloor > targetFloor) {
            if(currentFloor == 0) {
                direction = Direction.IDLE;
                return;
            }
            direction = Direction.DOWN;
            currentFloor--;
        }

        if (insideRequests.contains(currentFloor)) {
            openDoor();
            insideRequests.remove(currentFloor);
        }
    }

    public void openDoor() {
        elevatorDoorState = ElevatorDoorState.OPEN;
        System.out.println("Elevator " + id + " opened door at floor " + currentFloor);
    }

    public void closeDoor() {
        elevatorDoorState = ElevatorDoorState.CLOSE;
        System.out.println("Elevator id: " + id + "close door at floor+" + currentFloor);
    }

    public boolean isIdle() {
        return direction == Direction.IDLE && insideRequests.isEmpty();
    }


    public int getId() {
        return id;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ElevatorStatus getStatus() {
        return new ElevatorStatus(id, currentFloor, direction, elevatorDoorState, getPendingRequests());
    }

    public Set<Integer> getPendingRequests() {
        return new TreeSet<>(insideRequests);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ElevatorDoorState getElevatorDoorState() {
        return elevatorDoorState;
    }

    public void setElevatorDoorState(ElevatorDoorState elevatorDoorState) {
        this.elevatorDoorState = elevatorDoorState;
    }

    public TreeSet<Integer> getInsideRequests() {
        return insideRequests;
    }

    public void setInsideRequests(TreeSet<Integer> insideRequests) {
        this.insideRequests = insideRequests;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Boolean getOdd() {
        return isOdd;
    }

    public void setOdd(Boolean odd) {
        isOdd = odd;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "id=" + id +
                ", direction=" + direction +
                ", elevatorDoorState=" + elevatorDoorState +
                ", insideRequests=" + insideRequests +
                ", currentFloor=" + currentFloor +
                '}';
    }
}
