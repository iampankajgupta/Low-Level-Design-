package DesighPatterns.ObeserverDesignPattern;

import DesighPatterns.ObeserverDesignPattern.Enum.OrderStatus;

import static DesighPatterns.ObeserverDesignPattern.Enum.OrderStatus.SHIPPED;

public class DeliveryPartner implements Observer{
    @Override
    public void update(OrderEvent orderEvent) {
        if (OrderStatus.valueOf(orderEvent.getStatus()).equals(SHIPPED)) {
            System.out.println("Delivery partner: Pick up order " + orderEvent.getOrderId());
        }
    }
}
