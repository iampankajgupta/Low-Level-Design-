package DesighPatterns.ObeserverDesignPattern;

public class CustomerNotificationService implements Observer{
    @Override
    public void update(OrderEvent orderEvent) {
        System.out.println("Customer your order"+orderEvent.getOrderId()+"has now"+orderEvent.getStatus());
    }
}
