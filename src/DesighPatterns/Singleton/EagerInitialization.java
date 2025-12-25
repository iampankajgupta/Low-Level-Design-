package DesighPatterns.Singleton;

public class EagerInitialization {

    // We Eagerly created the instance of this object;
    /*
    1. ❗ No Lazy Initialization
        The instance is created as soon as the class is loaded, even if the application never uses it.

        This wastes memory or resources if the Singleton is heavy or rarely used.

        ⚠️ Imagine the Singleton connects to a DB or initializes large caches — if it's never used, you've wasted those resources.
     */
    private static EagerInitialization eagerInitialization = new EagerInitialization();

    private EagerInitialization() {

    }
    public static EagerInitialization getInstance() {
        return eagerInitialization;
    }

}
