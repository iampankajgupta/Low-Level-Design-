package DesighPatterns.ObeserverDesignPattern;

import static DesighPatterns.ObeserverDesignPattern.Enum.OrderStatus.PAID;

public class WareHouseNotificationService implements Observer{
    @Override
    public void update(OrderEvent orderEvent) {
        if(orderEvent.getStatus().equals(PAID.name())) {
            System.out.println("Warehouse: Prepare order " + orderEvent.getOrderId() + " for shipping.");
        }

    }
}
