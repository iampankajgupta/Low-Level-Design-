package LLD.ParkingLot.FareCalculator;

import LLD.ParkingLot.ParkingTicket;

public interface IFareCalculator {
    double calculateFare(ParkingTicket parkingTicket);
}
