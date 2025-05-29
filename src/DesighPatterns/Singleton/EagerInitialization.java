package DesighPatterns.Singleton;

public class EagerInitialization {

    // We Eagerly created the instance of this object;
    private static EagerInitialization eagerInitialization = new EagerInitialization();

    private EagerInitialization() {

    }
    public static EagerInitialization getInstance() {
        return eagerInitialization;
    }

}
