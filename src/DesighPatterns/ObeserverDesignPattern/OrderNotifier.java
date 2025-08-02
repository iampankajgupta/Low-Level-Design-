package DesighPatterns.ObeserverDesignPattern;

public class OrderNotifier implements Notifier {
    private Subject orderObserverRegistry;

    public OrderNotifier(Subject orderObserverRegistry) {
        this.orderObserverRegistry = orderObserverRegistry;
    }

    @Override
    public void notifyObserver(OrderEvent orderEvent) {
        for(Observer observer : orderObserverRegistry.observerCollection) {
            observer.update(orderEvent);
        }
    }
}
