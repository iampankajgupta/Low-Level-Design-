package DesighPatterns.ChainOfResponsibility.Logger;

public abstract class Logger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    protected Logger nextLogger;


    public Logger(int level) {
        this.level = level;
    }

    public void logMessage(int level, String message) {
        if(this.level >= level){
            write(message);
        }
        else if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }


    protected abstract void write(String message);
}
