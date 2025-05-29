package LLD.ParkingLot;

import LLD.ParkingLot.FareCalculator.IFareCalculator;
import LLD.ParkingLot.ParkingSpotManager.ParkingSpotManager;
import LLD.ParkingLot.PaymentStrategy.IPayment;
import LLD.ParkingLot.enums.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ParkingLot {

    List<EntryGate> entryGateList;
    List<ExitGate> exitGateList;
    ParkingSpotManager parkingSpotManager;
    IFareCalculator iFareCalculator;

    private ParkingLot(ParkingSpotManager parkingSpotManager, IFareCalculator iFareCalculator) {
        this.parkingSpotManager = parkingSpotManager;
        this.iFareCalculator = iFareCalculator;
    }

    public ParkingSpot issueParkingSpot(Vehicle vehicle) {
        return parkingSpotManager.issueParkingSpot(vehicle);
    }


    public ParkingTicket generateTicket(Vehicle vehicle, User user, ParkingSpot parkingSpot, EntryGate entryGate){
        String id = UUID.randomUUID().toString();
        return new ParkingTicket(id, System.currentTimeMillis(), parkingSpot, vehicle, user, entryGate);
    }

    public boolean payFare(ParkingTicket parkingTicket, IPayment payment) {
        boolean pay = payment.pay(iFareCalculator.calculateFare(parkingTicket));
        if(pay) {
            parkingSpotManager.unissueParkingSpot(parkingTicket);
            return true;
        }
        System.out.println("Issue Occured during payment");
        return false;

    }




}
