package OOPS.NotificationSystem;

public class SMSNotifier implements Notifier {

    private String mobileNumber;

    public SMSNotifier(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void notifyUser(String message) {

    }
}
