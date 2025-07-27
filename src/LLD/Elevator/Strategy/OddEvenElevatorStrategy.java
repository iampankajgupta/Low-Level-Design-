package LLD.Elevator.Strategy;

import LLD.Elevator.model.Elevator;
import LLD.Elevator.model.OutsideRequest;
import LLD.ElevtorDesign.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class OddEvenElevatorStrategy extends ElevatorAssignmentStrategy {

    @Override
    public Elevator assignElevator(List<Elevator> elevatorList, OutsideRequest outsideRequest) {
        // finding all the requested elevator like if it odd then all odd elevators or all even elevators
            List<Elevator> elevators = elevatorList.stream()
                    .filter(elevator -> elevator.getOdd() != null && elevator.getOdd().equals(outsideRequest.getFloor() % 2 != 0))
                    .collect(Collectors.toList());

            // find the best elevators out of the list based on the distance
        return findBestElevator(elevators, outsideRequest);
    }
}
