package LoggingSystem.LogRequestHandlers;

import LoggingSystem.DataSource.IDataSource;

public class DebugLogHandler extends LoggerHandler {

    public DebugLogHandler(int level, IDataSource iDataSource) {
        super(level, iDataSource);
    }

    @Override
    public void processLog(String message) {
        System.out.println("Debug handler handling log message: " + message);
    }
}
