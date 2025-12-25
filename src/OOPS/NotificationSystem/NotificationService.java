package OOPS.NotificationSystem;
import java.util.*;

public class NotificationService {
    private List<Notifier> notifierList;

    public NotificationService(List<Notifier> notifierList) {
        this.notifierList = notifierList;
    }

    public void sendToAll(String message) {
        for(Notifier notifier : notifierList) {
            notifier.notifyUser(message);
            System.out.println("-----------------------------");
        }
    }
}
