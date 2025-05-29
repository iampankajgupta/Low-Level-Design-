package LoggingSystem;

import LoggingSystem.DataSource.IDataSource;
import LoggingSystem.enums.LogLevel;

public class Config {
//    private String logLevel;
//    private String datasource;
//
//    public Config(String logLevel, String datasource) {
//        this.logLevel = logLevel;
//        this.datasource = datasource;
//    }
//
//    public String getLogLevel() {
//        return logLevel;
//    }
//
//    public void setLogLevel(String logLevel) {
//        this.logLevel = logLevel;
//    }
//
//    public String getDatasource() {
//        return datasource;
//    }
//
//    public void setDatasource(String datasource) {
//        this.datasource = datasource;
//    }


    private LogLevel logLevel;
    private IDataSource logAppender;
    public Config(LogLevel logLevel, IDataSource logAppender) {
        this.logLevel = logLevel;
        this.logAppender = logAppender;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public IDataSource getLogAppender() {
        return logAppender;
    }

    public void setLogAppender(IDataSource logAppender) {
        this.logAppender = logAppender;
    }
}
