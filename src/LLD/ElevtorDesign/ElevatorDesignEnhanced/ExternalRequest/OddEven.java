package LLD.ElevtorDesign.ElevatorDesignEnhanced.ExternalRequest;

import LLD.ElevtorDesign.Direction;
import LLD.ElevtorDesign.ElevatorDesignEnhanced.ElevatorController;

import java.util.List;

public class OddEven extends ExternalDispatcher{

    public OddEven(List<ElevatorController> elevatorControllerList) {
        super(elevatorControllerList);
    }

    @Override
    void acceptRequest(int floor, Direction direction) {

        // user stands at odd floor and needs to go odd floor --> assign odfd elevetor
        // user stands at odd floor and needs to go even floor -> assign fixed elevator
        // user stands at the even floor and needs to go odd floor -> assign fixed elevator
        // user stands at the even floor and needs to go to even floor -> assign even elevator
        // if the direction is up or down

        ElevatorController elevatorController = getElevatorController(direction, floor % 2 == 0, floor);
        if(elevatorController != null) {
            elevatorController.submitRequest(floor, direction);
            return;
        }
        System.out.println("Not Elevator found!!!!!!!!!!");

//        possible scenarios can occur
    }

    public ElevatorController getElevatorController(Direction direction, boolean isOdd, int floor) {
        for(ElevatorController elevator : elevatorControllerList) {
            if(elevator.getElevator().getDirection().equals(direction) && elevator.getElevator().isOdd() == isOdd)  {
                if(direction.equals(Direction.UP) && elevator.getElevator().getFloor() < floor) {
                    return elevator;
                }else if(direction.equals(Direction.DOWN) && elevator.getElevator().getFloor() > floor){
                    return elevator;
                }
            }
        }
        return null;
    }
}
