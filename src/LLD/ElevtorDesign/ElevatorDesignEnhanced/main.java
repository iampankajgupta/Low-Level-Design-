package LLD.ElevtorDesign.ElevatorDesignEnhanced;

import LLD.ElevtorDesign.Direction;
import LLD.ElevtorDesign.ElevatorDesignEnhanced.ExternalRequest.ExternalButton;
import LLD.ElevtorDesign.ElevatorDesignEnhanced.ExternalRequest.ExternalDispatcher;
import LLD.ElevtorDesign.ElevatorDesignEnhanced.ExternalRequest.OddEven;

import java.util.Arrays;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        Building building = new Building();

        Elevator elevator = new Elevator();
        elevator.setDirection(Direction.UP);
        elevator.setFixed(true);
        elevator.setFloor(2);
        elevator.setDisplay(new Display(2, Direction.UP));
        ElevatorController elevatorController = new ElevatorController();
        elevatorController.setElevator(elevator);
        ExternalDispatcher externalDispatcher = new OddEven(Arrays.asList(elevatorController));
        ExternalButton externalButton = new ExternalButton(externalDispatcher);
        externalButton.pressButton(5, Direction.UP);
    }
}
