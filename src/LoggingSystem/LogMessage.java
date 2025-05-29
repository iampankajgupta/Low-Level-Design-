package LoggingSystem;

import LoggingSystem.enums.LogLevel;

import java.util.UUID;

public class LogMessage {

    private LogLevel logLevel;
    private long timeStamp;
    private String message;


    public LogMessage(LogLevel logLevel, String message) {
        this.logLevel = logLevel;
        this.timeStamp = System.currentTimeMillis();
        this.message = message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static LogMessage createLogMessage(LogLevel logLevel, String message) {
        return new LogMessage(logLevel, message);
    }


    @Override
    public String toString() {
        return "LogMessage{" +
                ", logLevel=" + logLevel +
                ", timeStamp=" + timeStamp +
                ", message='" + message + '\'' +
                '}';
    }
}
