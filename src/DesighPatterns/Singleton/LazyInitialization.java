package DesighPatterns.Singleton;

public class LazyInitialization {

    private static LazyInitialization lazyInitialization;

    private LazyInitialization() {
    }


    // Not a thread Safe
    // Here Not Eagerly Initialised and when getInstance is called then only creating the instance but it is not threadSafe
    public static LazyInitialization getInstance(){
        if(lazyInitialization == null) {
            lazyInitialization = new LazyInitialization();
        }

        return lazyInitialization;
    }
}
