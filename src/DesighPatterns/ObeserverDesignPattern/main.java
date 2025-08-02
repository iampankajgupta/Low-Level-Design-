package DesighPatterns.ObeserverDesignPattern;

import DesighPatterns.ObeserverDesignPattern.Model.Order;

import java.util.concurrent.ConcurrentLinkedQueue;

public class main {
    public static void main(String[] args) {

    /*
            This is not text book type implementation which was violating SRP And DIP of SOLID principle
            In that Implementation we mostly initialised collection in Subject class only
            like List<Observer> observerList = new ArrayList<>(); --> which violates DIP principle that High Level Modules should not depend on low level modules
            and also we define addObserver, removeObserver, and notifyObserver in same class --> this violate SRP single responsibility principle

            Subject is Order
            Observer -> Customer, Warehouse, DeliveryPattern,
            When Order Status is being changed based on Class needs to be def

            Also segregated the responsibilities like for Notify Observer created Notifier class
            For Adding and Removing the Order Redistry class has been created which is extending it from Subject

     */

        Observer observer = new CustomerNotificationService();
        Observer observer1 = new WareHouseNotificationService();
        Observer observer2 = new DeliveryPartner();

        Subject orderObserverRegistry = new OrderObserverRegistry(new ConcurrentLinkedQueue<>());
        orderObserverRegistry.addObserver(observer);
        orderObserverRegistry.addObserver(observer1);
        orderObserverRegistry.addObserver(observer2);

        OrderNotifier orderNotifier = new OrderNotifier(orderObserverRegistry);
        Order order = new Order(orderNotifier);

        order.setOrderStatus("PAID");
        order.setOrderStatus("SHIPPED");
    }


}
