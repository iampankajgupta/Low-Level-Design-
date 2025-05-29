package LLD.ParkingLot.ParkingSpotManager;

import LLD.ParkingLot.ParkingSpot;
import LLD.ParkingLot.ParkingTicket;
import LLD.ParkingLot.Vehicle;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{

    public FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        super(parkingSpotList);
    }

    @Override
    public ParkingSpot issueParkingSpot(Vehicle vehicle) {
        return null;
    }

    @Override
    public ParkingSpot unissueParkingSpot(ParkingTicket ticket) {
        return null;
    }
}
