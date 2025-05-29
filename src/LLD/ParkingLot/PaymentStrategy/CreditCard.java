package LLD.ParkingLot.PaymentStrategy;

public class CreditCard implements IPayment{
    private String cardNumber;
    private String cvv;

    public CreditCard(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public boolean pay(double price) {
        return false;
    }
}
