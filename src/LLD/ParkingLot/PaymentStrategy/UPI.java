package LLD.ParkingLot.PaymentStrategy;

public class UPI implements IPayment {
    private String UPI;

    public UPI(String UPI) {
        this.UPI = UPI;
    }

    @Override
    public boolean pay(double price) {
        return false;
    }
}
