package SolidDesignPrinciple.DependencyInversion;

public class SMS implements NotificationManager{
  @Override
  public void notifySender() {
    System.out.println("Notifying user through SMS...");
  }
}
