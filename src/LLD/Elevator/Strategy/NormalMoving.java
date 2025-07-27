package LLD.Elevator.Strategy;

import LLD.Elevator.enums.ElevatorDoorState;
import LLD.Elevator.model.Elevator;
import LLD.ElevtorDesign.Direction;

public class NormalMoving implements ElevatorMovingStrategy {
    @Override
    public void move(Elevator elevator) {

        int currentFloor = elevator.getCurrentFloor();
        Direction direction = elevator.getDirection();
        if (elevator.getInsideRequests().isEmpty()) {
            elevator.setElevatorDoorState(ElevatorDoorState.IDLE);
            if (elevator.getCurrentFloor() != 0) {
                elevator.setCurrentFloor(currentFloor - 1);
//                elevator.setCurrentFloor(currentFloor--); // NEVER USE THIS IT WILL NOT WORK
                elevator.setDirection(Direction.DOWN);
            } else {
                elevator.setDirection(Direction.IDLE);
            }
            return;
        }

        int targetFloor = direction.equals(Direction.DOWN) ? elevator.getInsideRequests().first() : elevator.getInsideRequests().last();

        if (currentFloor < targetFloor) {
            elevator.setDirection(Direction.UP);
            elevator.setCurrentFloor(currentFloor + 1);
//            elevator.setCurrentFloor(currentFloor ++); // NEVER USE THIS IT WILL NOT WORK
        } else if (currentFloor > targetFloor && currentFloor <= elevator.getMaxFloor()) {
            if(currentFloor == 0) {
                elevator.setDirection(Direction.IDLE);
                return;
            }
            elevator.setDirection(Direction.DOWN);
            elevator.setCurrentFloor(currentFloor - 1);
        }

        if (elevator.getInsideRequests().contains(currentFloor)) {
            elevator.openDoor();
            elevator.getInsideRequests().remove(currentFloor);
        }
    }
}
