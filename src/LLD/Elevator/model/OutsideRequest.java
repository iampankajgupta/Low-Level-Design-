package LLD.Elevator.model;

import LLD.ElevtorDesign.Direction;

public class OutsideRequest extends ElevatorRequest{
    protected final Direction direction;
    public OutsideRequest(int floor, Direction direction) {
        super(floor);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Outside Request{" +
                "direction=" + direction +
                ", floor=" + floor +
                '}';
    }
}
