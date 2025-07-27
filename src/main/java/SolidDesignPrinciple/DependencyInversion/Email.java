package SolidDesignPrinciple.DependencyInversion;

public class Email implements NotificationManager{
  @Override
  public void notifySender() {
    System.out.println("Notifying user through email...");
  }
}
