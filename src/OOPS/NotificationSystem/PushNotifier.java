package OOPS.NotificationSystem;

public class PushNotifier implements Notifier {

    private String appToken;

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    @Override
    public void notifyUser(String message) {

    }
}
