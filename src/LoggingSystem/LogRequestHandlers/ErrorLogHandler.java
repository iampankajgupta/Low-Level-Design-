package LoggingSystem.LogRequestHandlers;

import LoggingSystem.DataSource.IDataSource;

public class ErrorLogHandler extends LoggerHandler {

    public ErrorLogHandler(int level, IDataSource iDataSource) {
        super(level, iDataSource);
    }

    @Override
    public void processLog(String message) {
        System.out.println("Error handler handling log message: "+message);

    }
}
