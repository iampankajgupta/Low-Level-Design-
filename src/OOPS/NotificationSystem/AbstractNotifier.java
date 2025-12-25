package OOPS.NotificationSystem;

public abstract class AbstractNotifier implements Notifier{
    private static final int MAX_RETRIES = 3;

    @Override
    public void notifyUser(String message) {
        int attempts = 0;
        while(attempts <= MAX_RETRIES) {
            if(send(message)) {
                System.out.println(getClass().getSimpleName() + " delivered successfully");
                return;
            }else {
                attempts++;
                System.out.println(getClass().getSimpleName() + " failed. Retry "
                        + attempts + "/" + MAX_RETRIES);
            }
        }
    }

    protected abstract boolean send(String message);
}
