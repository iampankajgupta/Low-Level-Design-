package LLD.Elevator.utility;

import LLD.Elevator.Strategy.ElevatorMovingStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ElevatorStrategyRegistry {
    private static Map<Integer, ElevatorMovingStrategy> elevatorMovingStrategyMap = new HashMap<>();

    public ElevatorStrategyRegistry(Map<Integer, ElevatorMovingStrategy> elevatorMovingStrategyMap) {
        this.elevatorMovingStrategyMap = elevatorMovingStrategyMap;
    }

    public Map<Integer, ElevatorMovingStrategy> getElevatorMovingStrategyMap() {
        return elevatorMovingStrategyMap;
    }

    public void setElevatorMovingStrategyMap(Map<Integer, ElevatorMovingStrategy> elevatorMovingStrategyMap) {
        this.elevatorMovingStrategyMap = elevatorMovingStrategyMap;
    }

    public static Optional<ElevatorMovingStrategy> getElevatorMovingStrategyById(int elevatorId) {
        return Optional.of(elevatorMovingStrategyMap.get(elevatorId));
    }

    public static void addToRegistry(int elevatorId, ElevatorMovingStrategy elevatorMovingStrategy) {
        elevatorMovingStrategyMap.put(elevatorId, elevatorMovingStrategy);
    }
}
