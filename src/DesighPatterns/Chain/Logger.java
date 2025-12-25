package DesighPatterns.Chain;

import LoggingSystem.enums.LogLevel;

public class Logger {
    private volatile Logger INSTANCE = null;

    private Logger(){}

    public Logger getInstance() {
        if(INSTANCE == null) {
            synchronized (this) {
                if(INSTANCE == null) {
                    INSTANCE = new Logger();
                }
            }
        }
        return INSTANCE;
    }

    private LogHandler logHandler;

    public void log(LogLevel logLevel, String message){
        logHandler.canHandle(logLevel);
    }

    public void info(String message){
        log(LogLevel.INFO, message);
    }
    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }
    public void error(String message){
        log(LogLevel.ERROR, message);
    }

}
