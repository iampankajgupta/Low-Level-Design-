package DesighPatterns.ObeserverDesignPattern.Model;

import DesighPatterns.ObeserverDesignPattern.OrderEvent;
import DesighPatterns.ObeserverDesignPattern.OrderNotifier;

import java.util.UUID;

public class Order{
    private String orderId;
    private String orderStatus;
    private OrderNotifier orderNotifier;

    // Based on the Order Status Logs will be printed
    public Order( OrderNotifier orderNotifier) {
        this.orderId = UUID.randomUUID().toString();
        this.orderStatus = "CREATED";
        this.orderNotifier = orderNotifier;
        notifyObservers();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        orderNotifier.notifyObserver(new OrderEvent(this.orderId, this.orderStatus));
    }

    public void notifyObservers() {
        OrderEvent orderEvent = new OrderEvent(this.orderId, this.orderStatus);
        orderNotifier.notifyObserver(orderEvent);
    }
}
