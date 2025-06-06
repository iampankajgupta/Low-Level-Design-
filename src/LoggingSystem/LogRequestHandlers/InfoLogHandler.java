package LoggingSystem.LogRequestHandlers;

import LoggingSystem.DataSource.IDataSource;
import LoggingSystem.DatasourceFactory.DatasourceFactory;
import LoggingSystem.LogMessage;
import LoggingSystem.enums.LogLevel;

public class InfoLogHandler extends LoggerHandler {


    public InfoLogHandler(int level, IDataSource iDataSource) {
        super(level, iDataSource);
    }

    @Override
        public void processLog(String message) {
//            if(config.getLogLevel().toUpperCase().equals(LogLevel.INFO.name())) {
//                LogMessage logMessage = LogMessage.createLogMessage(LogLevel.valueOf(config.getLogLevel().toUpperCase()), message);
//                System.out.println("Info handler handling log message: "+message);
//                IDataSource dataSource = DatasourceFactory.getInstance().getDataSource(config.getDatasource().toUpperCase());
//                dataSource.processLog(logMessage);
//            }else {
//                next.processLog(message);
//            }
        }
    }
