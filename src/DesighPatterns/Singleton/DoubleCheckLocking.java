package DesighPatterns.Singleton;

public class DoubleCheckLocking {

    private static DoubleCheckLocking doubleCheckLocking;

    private DoubleCheckLocking() {
    }


    // but due to synchroised still it is little bit slow

    public static DoubleCheckLocking getInstance() {
        // here we are not making entire method as synchronised so for the first tine class will be initlised and then later even if multiple thread access it will return
        // object
       if(doubleCheckLocking == null) {
           synchronized (DoubleCheckLocking.class) {
               if(doubleCheckLocking == null) {
                   doubleCheckLocking = new DoubleCheckLocking();

               }
           }
       }
       return doubleCheckLocking;
    }
}
