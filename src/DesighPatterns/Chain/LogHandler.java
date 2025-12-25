package DesighPatterns.Chain;

import DesighPatterns.ChainOfResponsibility.Handler;
import LoggingSystem.enums.LogLevel;

public abstract class LogHandler {
    protected LogHandler next;
    protected Appender appender;

    public void setNext(LogHandler logHandler) {
        this.next = logHandler;
    }
    protected abstract boolean canHandle(LogLevel level);
    protected abstract void handle(LogMessage logMessage);

}
