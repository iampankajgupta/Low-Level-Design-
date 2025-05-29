package DesighPatterns.Singleton;

public class SynchronisedWay {
    private static SynchronisedWay synchronisedWay;

    private SynchronisedWay() {
    }

    // but it is very slow cause every time thread access locking and unlocking will happen
    public static synchronized SynchronisedWay getInstance() {
        if(synchronisedWay == null) {
            synchronisedWay = new SynchronisedWay();
        }
        return synchronisedWay;
    }
}
