package LoggingSystem.DataSource;

import LoggingSystem.LogMessage;

import java.util.List;

public class Database implements IDataSource{

    @Override
    public boolean processLog(LogMessage message) {
        return false;
    }

    @Override
    public List<LogMessage> exportLogs() {
        return List.of();
    }

    @Override
    public boolean clear() {
        return false;
    }
}
