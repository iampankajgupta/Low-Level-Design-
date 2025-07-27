package LLD.ElevtorDesign.ElevatorDesignEnhanced.ExternalRequest;

import LLD.ElevtorDesign.Direction;
import LLD.ElevtorDesign.ElevatorDesignEnhanced.ElevatorController;

import java.util.List;

public class Fixed extends ExternalDispatcher{
    public Fixed(List<ElevatorController> elevatorControllerList) {
        super(elevatorControllerList);
    }

    @Override
    void acceptRequest(int floor, Direction direction) {

    }
}
