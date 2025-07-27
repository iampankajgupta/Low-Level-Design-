package LLD.Elevator.model;

public class InsideRequest extends ElevatorRequest{

    public InsideRequest(int floor) {
        super(floor);
    }

    @Override
    public String toString() {
        return "InternalRequest to floor :"+floor;
    }
}
