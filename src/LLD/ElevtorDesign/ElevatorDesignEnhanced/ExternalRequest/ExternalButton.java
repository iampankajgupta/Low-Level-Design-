package LLD.ElevtorDesign.ElevatorDesignEnhanced.ExternalRequest;

import LLD.ElevtorDesign.Direction;

public class ExternalButton {

    private ExternalDispatcher externalDispatcher;

    public ExternalButton(ExternalDispatcher externalDispatcher) {
        this.externalDispatcher = externalDispatcher;
    }

    public void pressButton(int floor, Direction direction) {
        externalDispatcher.acceptRequest(floor, direction);
    }
}
