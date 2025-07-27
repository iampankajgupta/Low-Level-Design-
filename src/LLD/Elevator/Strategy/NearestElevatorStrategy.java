package LLD.Elevator.Strategy;

import LLD.Elevator.model.Elevator;
import LLD.Elevator.model.OutsideRequest;
import LLD.ElevtorDesign.Direction;

import java.util.List;

public class NearestElevatorStrategy extends ElevatorAssignmentStrategy {


    public Elevator assignElevator(List<Elevator> elevatorList, OutsideRequest outsideRequest) {
        Elevator baseElevator = null;
        int requestedFloor = outsideRequest.getFloor();
        Direction requestedDirection = outsideRequest.getDirection();

        int minDistFromReqFloor = Integer.MAX_VALUE;
        for (Elevator elevator : elevatorList) {
            int currentFloorElevatorFloor = elevator.getCurrentFloor();

            // if the elevator is idle,
            if(elevator.getDirection().equals(requestedDirection)) {
                if (elevator.getDirection().equals(Direction.IDLE) || (requestedDirection.equals(Direction.UP) && currentFloorElevatorFloor <= requestedFloor) || (requestedDirection.equals(Direction.DOWN)
                        && currentFloorElevatorFloor >= requestedFloor)) {
                    int distance = Math.abs(currentFloorElevatorFloor - requestedFloor);
                    if (distance < minDistFromReqFloor) {
                        minDistFromReqFloor = distance;
                        baseElevator = elevator;
                    }
                }
            }
        }

        // fallback: choose any idle elevator if nothing else matches
        if (baseElevator == null) {
            for (Elevator elevator : elevatorList) {
                if (elevator.isIdle()) {
                    return elevator;
                }
            }
        }
        return baseElevator;
    }
}
