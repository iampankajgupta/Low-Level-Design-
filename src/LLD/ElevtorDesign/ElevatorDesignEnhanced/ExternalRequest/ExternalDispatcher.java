package LLD.ElevtorDesign.ElevatorDesignEnhanced.ExternalRequest;

import LLD.ElevtorDesign.Direction;
import LLD.ElevtorDesign.ElevatorDesignEnhanced.ElevatorController;

import java.util.List;

public abstract class ExternalDispatcher {
    List<ElevatorController> elevatorControllerList;

    public ExternalDispatcher(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    abstract void acceptRequest(int floor, Direction direction) ;
}
