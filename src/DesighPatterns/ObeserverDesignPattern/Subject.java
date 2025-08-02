package DesighPatterns.ObeserverDesignPattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class Subject {
    protected final Collection<Observer> observerCollection;

    public Subject(Collection<Observer> observerCollection) {
        this.observerCollection = observerCollection;
    }
     void addObserver(Observer observer)  {
        observerCollection.add(observer);
     }

     void removeObserver(Observer observer) {
        observerCollection.remove(observer);
    }
}
