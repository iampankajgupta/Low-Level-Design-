package LoggingSystem.DataSource;

import LoggingSystem.LogMessage;

import java.util.List;

public interface IDataSource {

    boolean processLog(LogMessage message);
    List<LogMessage> exportLogs();
    boolean clear();
 }
