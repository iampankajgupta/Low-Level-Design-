package LLD.ParkingLot.ParkingSpotManager;

import LLD.ParkingLot.ParkingSpot;
import LLD.ParkingLot.ParkingTicket;
import LLD.ParkingLot.Vehicle;
import LLD.ParkingLot.enums.VehicleType;

import java.util.List;
import java.util.Optional;

public abstract class ParkingSpotManager {

    protected List<ParkingSpot> parkingSpotList;

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    // findParkingSpot by vehicleType
    public Optional<ParkingSpot> findParkingSpot(Vehicle vehicle) {
        return parkingSpotList.stream().filter(parkingSpot -> parkingSpot.isAvailable() && parkingSpot.getSlotType().equals(vehicle.getVehicleType())).findAny();

    }

    public abstract ParkingSpot issueParkingSpot(Vehicle vehicle);
    public abstract ParkingSpot unissueParkingSpot(ParkingTicket ticket);

}
