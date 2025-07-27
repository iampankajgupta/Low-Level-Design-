package LLD.ElevtorDesign;

import javax.xml.stream.events.EndElement;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ElevatorService {
    private static Map<Direction, List<Elevator>> elevatorMap;

    public ElevatorService() {
        elevatorMap = new ConcurrentHashMap<>();
    }

    public synchronized void addRequest(Request request){
        if(request.getDirection().equals(Direction.UP)) {
            List<Elevator> elevators = elevatorMap.get(Direction.UP);

            int diff = Integer.MAX_VALUE;
            int index = -1;
            for(int i = 0; i <elevators.size(); i++) {
                if(elevators.get(i).getFloor() < request.getCurrentFloor()) {
                    if(diff > Math.abs(elevators.get(i).getFloor() - request.getCurrentFloor())){
                        index = i;
                        diff = Math.abs(elevators.get(i).getFloor() - request.getCurrentFloor());
                    }
                }
            }
            elevators.get(index).getRequests().add(request);

        }else {
            List<Elevator> elevators = elevatorMap.get(Direction.UP);

            int diff = Integer.MAX_VALUE;
            int index = -1;
            for(int i = 0; i <elevators.size(); i++) {
                if(elevators.get(i).getFloor() < request.getCurrentFloor()) {
                    if(diff > Math.abs(elevators.get(i).getFloor() - request.getCurrentFloor())){
                        index = i;
                        diff = Math.abs(elevators.get(i).getFloor() - request.getCurrentFloor());
                    }
                }
            }
            elevators.get(index).getRequests().add(request);
        }
    }
}
