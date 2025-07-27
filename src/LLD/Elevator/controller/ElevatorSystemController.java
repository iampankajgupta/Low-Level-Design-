package LLD.Elevator.controller;

import LLD.Elevator.Strategy.ElevatorMovingStrategy;
import LLD.Elevator.model.Elevator;
import LLD.Elevator.model.OutsideRequest;
import LLD.Elevator.Strategy.ElevatorAssignmentStrategy;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ElevatorSystemController {

    private final List<Elevator> elevatorList;
//    private int maxFloor;
//    private int minFloor;
    private ElevatorAssignmentStrategy requestScheduler; // Strategy to handle multiple
    private Queue<OutsideRequest> pendingRequest;
    private Map<Integer, ElevatorMovingStrategy> elevatorMovingStrategyMap;

    // this constructor is being used when only single to elevators should be created
    public ElevatorSystemController(List<Elevator> elevatorList, ElevatorAssignmentStrategy requestScheduler, Map<Integer, ElevatorMovingStrategy> elevatorMovingStrategyMap) {
        this.requestScheduler = requestScheduler;
//        for (int i = 0; i < noOfElevator; i++) {
//            elevatorList.add(new Elevator(i, maxFloor, minFloor, elevatorMovingStrategy));
//        }

        // for better concurrency
        pendingRequest = new ConcurrentLinkedQueue<>();
        this.elevatorList = elevatorList;
        this.elevatorMovingStrategyMap = elevatorMovingStrategyMap;
    }

    public void acceptOutSideRequest(OutsideRequest outsideRequest) {
        Elevator elevator = requestScheduler.assignElevator(elevatorList, outsideRequest);
        if (elevator != null) {
            elevator.addExternalRequest(outsideRequest.getFloor());
            System.out.println("Assigned Elevator: " + elevator.getId() + " is being assigned to the request " + outsideRequest+ " is going "+elevator.getDirection());
        } else {
            System.out.println("All the elevators are busy queueing request: " + outsideRequest);
            pendingRequest.add(outsideRequest);
        }
    }

    public void stepSimulation() {
        // Retry
        if (!pendingRequest.isEmpty()) {
            Queue<OutsideRequest> retryQueue = new LinkedList<>();
            while (!pendingRequest.isEmpty()) {
                OutsideRequest request = pendingRequest.poll();
                Elevator assignedElevator = requestScheduler.assignElevator(elevatorList, request);
                if (assignedElevator != null) {
                    assignedElevator.addExternalRequest(request.getFloor());
                    System.out.println("Elevator: " + assignedElevator.getId() + "is being assigned to the request" + request);
                } else {
                    retryQueue.add(request);
                }
            }
        }
        for (Elevator elevator : elevatorList) {
            ElevatorMovingStrategy elevatorMovingStrategy = elevatorMovingStrategyMap.get(elevator.getId());
            elevatorMovingStrategy.move(elevator);

            // I was thinking that i want loop and replace
            // search and replace

            /// further update in the list
        }
    }

    public void printSystemStatus() {
        System.out.println("Elevator status: ");
        for (Elevator elevator : elevatorList) {
            System.out.println("Elevator: " + elevator.getId() + ": Elevator Status " + elevator.getStatus() + " is at floor " + elevator.getCurrentFloor() + " and moving in direction " + elevator.getDirection());
        }
    }

    public Queue<OutsideRequest> getPendingRequest() {
        return pendingRequest;
    }

    public void setPendingRequest(Queue<OutsideRequest> pendingRequest) {
        this.pendingRequest = pendingRequest;
    }

    public Map<Integer, ElevatorMovingStrategy> getElevatorMovingStrategyMap() {
        return elevatorMovingStrategyMap;
    }

    public void setElevatorMovingStrategyMap(Map<Integer, ElevatorMovingStrategy> elevatorMovingStrategyMap) {
        this.elevatorMovingStrategyMap = elevatorMovingStrategyMap;
    }

    public ElevatorAssignmentStrategy getRequestScheduler() {
        return requestScheduler;
    }

    public void setRequestScheduler(ElevatorAssignmentStrategy requestScheduler) {
        this.requestScheduler = requestScheduler;
    }

    public List<Elevator> getElevatorList() {
        return elevatorList;
    }
}
