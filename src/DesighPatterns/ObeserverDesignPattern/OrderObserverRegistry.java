package DesighPatterns.ObeserverDesignPattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderObserverRegistry extends Subject {
    public OrderObserverRegistry(Collection<Observer> observerCollection) {
        super(observerCollection);
    }
}
