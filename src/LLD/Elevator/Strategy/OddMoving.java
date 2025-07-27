package LLD.Elevator.Strategy;

import LLD.Elevator.model.Elevator;
import LLD.ElevtorDesign.Direction;

public class OddMoving implements ElevatorMovingStrategy{
    @Override
    public void move(Elevator elevator) {
        // related to idle
        // if elevator should not beyond maxFloor
        // if elevator should not go below minFlor
        
        int currentFloor = elevator.getCurrentFloor();
        Direction elevatorDirection = elevator.getDirection();
        if(elevator.getInsideRequests().isEmpty()) {
            if(currentFloor > elevator.getMinFloor() && currentFloor<= elevator.getMaxFloor()) {
                elevator.setDirection(Direction.DOWN);
                elevator.setCurrentFloor(currentFloor - 2);
            }
            else if(elevator.getCurrentFloor() == elevator.getMinFloor()) {
                elevator.setDirection(Direction.IDLE);
            }
        }

        int target = elevatorDirection.equals(Direction.DOWN) ? elevator.getInsideRequests().first() : elevator.getInsideRequests().last();
        
        if(currentFloor > target && currentFloor <=  elevator.getMaxFloor()) {
            elevator.setDirection(Direction.DOWN);
            elevator.setCurrentFloor(currentFloor - 2);
        }else if(currentFloor < target && currentFloor <= elevator.getMinFloor()) {
            elevator.setDirection(Direction.UP);
            elevator.setCurrentFloor(currentFloor + 2);
        }else if(elevator.getInsideRequests().contains(currentFloor)){
           elevator.openDoor();
           elevator.getInsideRequests().remove(currentFloor);
           elevator.closeDoor();
        }
    }
}
