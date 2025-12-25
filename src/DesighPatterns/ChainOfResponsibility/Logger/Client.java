package DesighPatterns.ChainOfResponsibility.Logger;

public class Client {

    private static Logger getChainOfLoggers() {
        Logger infoLogger = new InfoLogger(Logger.INFO);
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        infoLogger.setNextLogger(errorLogger);
        return infoLogger;
    }
    public static void main(String[] args) {
        Logger logger = getChainOfLoggers();
        logger.logMessage(Logger.ERROR, "Hello world");


    }


}
