package LoggingSystem;

import DesighPatterns.ChainOfResponsibility.LogHandler;
import LoggingSystem.DataSource.Database;
import LoggingSystem.DataSource.FileAppender;
import LoggingSystem.DataSource.IDataSource;
import LoggingSystem.LogRequestHandlers.DebugLogHandler;
import LoggingSystem.LogRequestHandlers.ErrorLogHandler;
import LoggingSystem.LogRequestHandlers.InfoLogHandler;
import LoggingSystem.LogRequestHandlers.LoggerHandler;
import LoggingSystem.enums.LogLevel;

public class main {

    private static LoggerHandler getChainOfLoggers(IDataSource iDataSource) {
        LoggerHandler errorLogger = new ErrorLogHandler(LogLevel.ERROR.value, iDataSource);
        LoggerHandler debugLogger = new DebugLogHandler(LogLevel.DEBUG.value, iDataSource);
        LoggerHandler infoLogger = new InfoLogHandler(LogLevel.INFO.value, iDataSource);
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);
        return infoLogger;
    }

    public static void main(String[] args) {
//        Config cnf = new Config("info", "log");
//        Logger logger = new InfoLogHandler(new DebugLogHandler(new ErrorLogHandler(null)));
//        logger.processLog("Hello World");
//        cnf.setLogLevel("error");
//        logger.processLog("Hello World2");
//        IDataSource log = DatasourceFactory.getInstance().getDataSource("log");
//        List<LogMessage> logMessages = log.exportLogs();
//
//        for(LogMessage logMessage: logMessages) {
//            System.out.println(logMessage.toString());
//        }
//
//        cnf.setLogLevel("error");
//        cnf.setDatasource("database");
//        logger.processLog(cnf, "Hello world");

        IDataSource fileDataSource = new FileAppender("");
        IDataSource dataSource = new Database();

        LoggerHandler chainOfLoggers = getChainOfLoggers(fileDataSource);
        chainOfLoggers.logMessage(LogLevel.INFO.value, "hello World");




    }
}
