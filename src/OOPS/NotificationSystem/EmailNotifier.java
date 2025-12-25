package OOPS.NotificationSystem;
import java.util.List;

public class EmailNotifier extends AbstractNotifier {
    @Override
    protected boolean send(String message) {
        System.out.println("Sending EMAIL: "+message);
        return false;
    }
}
