package LLD.ParkingLot.PaymentStrategy;

public class Cash implements IPayment{
    @Override
    public boolean pay(double price) {
        return false;
    }
}
