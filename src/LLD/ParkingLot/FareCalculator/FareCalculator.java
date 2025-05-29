package LLD.ParkingLot.FareCalculator;

import LLD.ParkingLot.ParkingTicket;
import LLD.ParkingLot.Vehicle;
import LLD.ParkingLot.enums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class FareCalculator implements IFareCalculator{

    static Map<VehicleType, Long> fare = new HashMap<>();

    static {
        fare.put(VehicleType.TWO_WHEELER, 10L);
        fare.put(VehicleType.FOUR_WHEELER, 20L);
    }

    public synchronized double calculateFare(ParkingTicket parkingTicket) {
        //calculate based on hourly, minute
        return computeFare(parkingTicket);
    }


    public double computeFare(ParkingTicket parkingTicket) {
        long entryTime = parkingTicket.getEntryTime();
        long exitTime = System.currentTimeMillis();
        long durationStay = exitTime - entryTime;
        VehicleType vehicleType = parkingTicket.getVehicle().getVehicleType();
        return fare.get(vehicleType) * durationStay;
    }
}
