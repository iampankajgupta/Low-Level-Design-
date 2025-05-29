package LoggingSystem.LogRequestHandlers;

import LoggingSystem.DataSource.IDataSource;
import LoggingSystem.LogMessage;
import LoggingSystem.enums.LogLevel;

public abstract class LoggerHandler {
    protected LoggerHandler next;

    public static int DEBUG = 3;
    public static int INFO = 2;
    public static int ERROR = 1;

    protected int level;
    protected IDataSource iDataSource;


    public LoggerHandler(int level, IDataSource iDataSource) {
        this.level = level;
        this.iDataSource = iDataSource;
    }

    public LoggerHandler getNext() {
        return next;
    }

    public void setNextLogger(LoggerHandler next) {
        this.next = next;
    }

    public void logMessage(int level, String message) {
        if(this.level >= level) {
            LogLevel logLevel = intoLogLevel(level);
            LogMessage logMessage = LogMessage.createLogMessage(logLevel, message);
            if (iDataSource != null)
                iDataSource.processLog(logMessage);
            processLog(message);
        }else {
            next.logMessage(level, message);
        }
    }

    private LogLevel intoLogLevel(int level) {
        switch (level) {
            case INFO:
                return LogLevel.INFO;
            case DEBUG:
                return LogLevel.DEBUG;
            case ERROR:
                return LogLevel.ERROR;
        }
    }

    public abstract void processLog(String message);
}
