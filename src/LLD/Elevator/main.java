package LLD.Elevator;

import LLD.Elevator.Strategy.*;
import LLD.Elevator.controller.ElevatorSystemController;
import LLD.Elevator.model.Elevator;
import LLD.Elevator.model.OutsideRequest;
import LLD.Elevator.utility.ElevatorStrategyRegistry;
import LLD.ElevtorDesign.Direction;

import java.util.*;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Elevator elevator1 = new Elevator(1,0, 10, null);
        Elevator elevator2 = new Elevator(2,0, 10, null);
//        Elevator elevator3 = new Elevator(3,1, 9, false);
//        Elevator elevator4 = new Elevator(3,0, 10, true);

        Map<Integer, ElevatorMovingStrategy> elevatorMovingStrategyMap = new HashMap<>();
        elevatorMovingStrategyMap.put(1, new NormalMoving());
        elevatorMovingStrategyMap.put(2, new NormalMoving());


        ElevatorStrategyRegistry elevatorStrategyRegistry = new ElevatorStrategyRegistry(elevatorMovingStrategyMap);

//        elevatorMovingStrategyMap.put(3, new OddMoving());
//        elevatorMovingStrategyMap.put(4, new EvenMoving());
        ElevatorSystemController elevatorSystemController = new ElevatorSystemController(Arrays.asList(elevator1, elevator2), new NearestElevatorStrategy(), elevatorStrategyRegistry.getElevatorMovingStrategyMap());
//        elevatorSystemController.setRequestScheduler(new OddEvenElevatorStrategy());

        elevatorSystemController.acceptOutSideRequest(new OutsideRequest(1, Direction.UP));
        elevatorSystemController.acceptOutSideRequest(new OutsideRequest(2, Direction.UP));
        elevatorSystemController.acceptOutSideRequest(new OutsideRequest(3, Direction.UP));
        elevatorSystemController.acceptOutSideRequest(new OutsideRequest(2, Direction.DOWN));

//        elevatorSystemController.getElevatorList().get(0).addInternalRequest(5, true);

        // When multiple elevators will be used

        for (int i = 1; i <= 10; i++) {
            elevatorSystemController.stepSimulation();
            elevatorSystemController.printSystemStatus();
            Thread.sleep(1000);
        }
    }
}

