package OOPS.NotificationSystem;

import java.util.*;

public class client {
    public static void main(String[] args) {
        List<Notifier> notifierList = new ArrayList<>();
        notifierList.add(new EmailNotifier());
        notifierList.add(new SMSNotifier(""));
        notifierList.add(new PushNotifier());

        NotificationService notificationService = new NotificationService(notifierList);
        notificationService.sendToAll("Hello World");

    }
}
